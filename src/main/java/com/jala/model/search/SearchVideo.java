/*
 * @(#) SearchVideo.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search;

import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.criteria.CriteriaSearchMultimedia;
import com.jala.model.search.asset.Asset;
import com.jala.utils.AssetFactory;
import com.jala.utils.Common;
import com.jala.utils.Logs;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * SearchVideo.
 * It searches the files for the specials characters of Video.
 *
 * @author Regis Humana
 * @version 0.0.1
 */
public class SearchVideo extends SearchCommon {

	/** Asset list. */
	private List<Asset> result;

	/** Criteria multimedia. */
	private CriteriaSearchMultimedia criteriaSearchVideo;

	/** It creates to follow up the instruction of the class. */
	private Logger log = Logs.getInstance().getLog();

	/** Path of the ffprobe. */
	private String FFPROBE_PATH = SearchFile.class.getClassLoader().getResource("ThirdParty/ffmpeg/bin/ffprobe.exe").getPath();

	/**
	 * Receive the criteria and cast the criteria into CriteriaSearchMultimedia.
	 * @param criteria
	 */
	public SearchVideo(CriteriaSearch criteria) {
		super(criteria);
		criteriaSearchVideo = (CriteriaSearchMultimedia) criteria;
	}

	/**
	 * Receive all the file that found in Search common, and deliver a list with the filters that was made for the
	 * customer, in special video.
	 *
	 * @return List<Asset> result.
	 */
	@Override
	public List<Asset> search() {
		log.info("The search for Video is beginning");
		result = new ArrayList<>();
		List<Asset> preview = super.search();
		for (int i = 0; i < preview.size(); i++) {
			FFprobe ffprobe;
			FFmpegProbeResult ffprobeResult;
			try {
				ffprobe = new FFprobe(Common.cleanPath(FFPROBE_PATH));
				ffprobeResult = ffprobe.probe(preview.get(i).getPath());
				boolean resultSearchVideo = true;
				Asset asset;
				double frameRateProbe = new BigDecimal(ffprobeResult.getStreams().get(0).
						avg_frame_rate.doubleValue()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
				if (!criteriaSearchVideo.getFrameRate().equals("")) {
					double frameRate = Double.parseDouble(criteriaSearchVideo.getFrameRate());
					if (resultSearchVideo && !(frameRate == frameRateProbe)) {
						resultSearchVideo = false;
					}
				}
				if (!criteriaSearchVideo.getAudioSampleRate().equals("")) {
					double sampleRate = Double.parseDouble(criteriaSearchVideo.getAudioSampleRate());
					if (resultSearchVideo && !(sampleRate >= ffprobeResult.getStreams().get(1).sample_rate)) {
						resultSearchVideo = false;
					}
				}
				if (!criteriaSearchVideo.getDuration().equals("")) {
					double durationCriteria = Double.parseDouble(criteriaSearchVideo.getDuration()) * 60;
					if (resultSearchVideo && !(durationCriteria >= ffprobeResult.getStreams().get(0).duration)) {
						resultSearchVideo = false;
					}
				}
				if (resultSearchVideo && !(ffprobeResult.getStreams().get(0).codec_long_name).contains(criteriaSearchVideo.getVideoCodec())) {
					if (!criteriaSearchVideo.getVideoCodec().equals("")) {
						resultSearchVideo = false;
					}
				}
				if (resultSearchVideo && !(ffprobeResult.getStreams().get(0).codec_long_name).contains(criteriaSearchVideo.getAudioCodec())) {
					if (!criteriaSearchVideo.getAudioCodec().equals("")) {
						resultSearchVideo = false;
					}
				}
				if (resultSearchVideo && !(criteriaSearchVideo.getAspectRatio().equals(ffprobeResult.getStreams().get(0).display_aspect_ratio))) {
					if (!criteriaSearchVideo.getAspectRatio().equals("")) {
						resultSearchVideo = false;
					}
				}
				if (resultSearchVideo && !(criteriaSearchVideo.getChannel().equals(ffprobeResult.getStreams().get(0).channel_layout))) {
					if (!criteriaSearchVideo.getChannel().equals("")) {
						resultSearchVideo = false;
					}
				}
				if (resultSearchVideo) {
					asset = AssetFactory.getAsset(preview.get(i),
							ffprobeResult.getStreams().get(0).codec_long_name,
							ffprobeResult.getStreams().get(0).codec_long_name,
							String.valueOf(frameRateProbe),
							ffprobeResult.getStreams().get(0).display_aspect_ratio,
							Integer.toString(ffprobeResult.getStreams().get(0).sample_rate),
							String.valueOf(ffprobeResult.getStreams().get(0).duration));
					result.add(asset);
				}

			} catch (IOException event) {
				log.error("The criteria values shouldn't be null...", event);
			} catch (NumberFormatException event) {
				log.error("Error in conversion in numbers...", event);
			}
		}
		log.info("The search for Video finished");
		return result;
	}
}
