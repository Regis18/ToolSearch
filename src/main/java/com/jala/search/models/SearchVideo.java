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

package com.jala.search.models;

import com.jala.utils.AssetFactory;
import com.jala.utils.Logs;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchVideo extends SearchCommon {
	private List<Asset> result;
	private CriteriaSearchMultimedia criteriaSearchVideo;
	private CriteriaSearch criteria;
	/** It creates to follow up the instruction of the class*/
	private Logger log = Logs.getInstance().getLog();

	private static String FFPROBE_PATH = SearchFile.class.getClassLoader()
			.getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffprobe.exe";

	public SearchVideo(CriteriaSearch criteria) {
		super(criteria);
		this.criteria = criteria;
		criteriaSearchVideo = (CriteriaSearchMultimedia) criteria;
	}

	@Override
	public List<Asset> search() {
		result = new ArrayList<>();
		List<Asset> preview = super.search();
		for (int i = 0; i < preview.size(); i++) {
			FFprobe ffprobe;
			FFmpegProbeResult ffprobeResult;
			try {
				ffprobe = new FFprobe(FFPROBE_PATH);
				ffprobeResult = ffprobe.probe(preview.get(i).getPath());
				boolean resultSearchVideo = true;
				Asset asset;
				/*if (resultSearchVideo && !(criteriaSearchVideo.getFrameRate()).equals(ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator())) {
					resultSearchVideo = false;
					System.out.println("FrameRate " + ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator());
				}
				if (!resultSearchVideo && !(criteriaSearchVideo.getVideoCodec()).equals(ffprobeResult.getStreams().get(0).codec_long_name)) {
					resultSearchVideo = false;
					System.out.println("VideoCodec " + ffprobeResult.getStreams().get(0).codec_long_name);
				}
				if (!resultSearchVideo && !(criteriaSearchVideo.getAudioCodec()).equals(ffprobeResult.getStreams().get(0).codec_tag_string)) {
					resultSearchVideo = false;
					System.out.println("AudioCodec " + ffprobeResult.getStreams().get(0).codec_tag_string);
				}
				if (!resultSearchVideo && !(criteriaSearchVideo.getAspectRatio().equals(ffprobeResult.getStreams().get(0).display_aspect_ratio))) {
					resultSearchVideo = false;
					System.out.println("AspectRatio " + ffprobeResult.getStreams().get(0).display_aspect_ratio);
				}
				if (!resultSearchVideo && !(criteriaSearchVideo.getAudioSampleRate().equals(ffprobeResult.getStreams().get(0).sample_aspect_ratio))) {
					resultSearchVideo = false;
					System.out.println("AudioSampleRate " + ffprobeResult.getStreams().get(0).sample_aspect_ratio);
				}
				if (!resultSearchVideo && !(criteriaSearchVideo.getDuration().equals(ffprobeResult.getStreams().get(0).duration))) {
					resultSearchVideo = false;
					System.out.println("Duration " + ffprobeResult.getStreams().get(0).duration);
				}*/
				System.out.println("PRoble: " + ffprobeResult.getStreams().get(1).channel_layout);
				System.out.println("SS: " + criteriaSearchVideo.getChannel());
				if (resultSearchVideo && !(criteriaSearchVideo.getChannel().equals(ffprobeResult.getStreams().get(1).channel_layout))) {
					resultSearchVideo = false;
				}
				if (resultSearchVideo) {
					asset = AssetFactory.getAsset(preview.get(0),
							ffprobeResult.getStreams().get(0).codec_long_name,
							ffprobeResult.getStreams().get(0).codec_tag_string,
							String.valueOf(ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator()),
							ffprobeResult.getStreams().get(0).display_aspect_ratio,
							ffprobeResult.getStreams().get(0).sample_aspect_ratio,
							String.valueOf(ffprobeResult.getStreams().get(0).duration));
					result.add(asset);
				}

			} catch (IOException event) {
				log.error("The criteria values shouldn't be null...", event);
			}
		}
		return result;
	}
}
