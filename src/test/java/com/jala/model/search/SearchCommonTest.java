/*
 * @(#) SearchCommonTest.java Copyright (c) 2019 Jala Foundation.
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
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

import static org.junit.Assert.assertEquals;

/**
 * SearchCommonTest
 *
 * @version 0.0.1
 * @author Regis Hummana
 */
public class SearchCommonTest {

	/**
	 *
	 */
	private CriteriaSearch criteriaSearch;

	@Before
	public void setUp() {
		criteriaSearch = new CriteriaSearch("..\\ToolSearch\\src\\test\\resources\\testfiles");
	}

	/**
	 * Search just path.
	 * The result is 6.
	 */
	@Test
	public void getResult_ReturnPaths_WhenSentPath() {
		SearchCommon search = new SearchCommon(criteriaSearch);
		int actual = search.search().size();
		int expected = 6;
		assertEquals(expected, actual);
	}

	/**
	 * Search with Path: nothing
	 * Result zero files.
     */
	@Test
	public void getResult_ReturnPaths_WhenSentWrongPath() {
		criteriaSearch.setPath("nothing");
		SearchCommon search = new SearchCommon(criteriaSearch);
		int actual = search.search().size();
		int expected = 0;
		assertEquals(expected, actual);
	}


	/**
	 * Search with Extension : mp4.
	 * Result 1 file.
	 */
	@Test
	public void getResult_ReturnPaths_WhenSentOnlyMP4() {
		criteriaSearch.setExtension("mp4");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with Extension:poo.
	 * Result zero files.
     */
	@Test
	public void getResult_ReturnPaths_WhenSentOnlyWrongExtension() {
		criteriaSearch.setExtension("poo");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with Extension : mp4
	 * Hidden: true
	 * Result file 1.
	 */
	@Test
	public void getResult_ReturnHidden_WhenSentPath() {
		criteriaSearch.setExtension("txt");
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}


	/**
	 * Search with Extension : mp4
	 * Hidden: false.
	 * Result file 1.
	 */
	@Test
	public void getResult_ReturnReadTrue_WhenSentPath() {
		criteriaSearch.setExtension("txt");
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyFalse);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with Extension : mp3
	 * Hidden: true.
	 * ReadOnly: true.
	 * Result file 1.
	 */
	@Test
	public void getResult_ReturnReadHiddenTrue_WhenSentPath() {
		criteriaSearch.setExtension("txt");
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyTrue);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}


	/**
	 * Search with Extension : mp4
	 * Hidden: true.
	 * ReadOnly: false.
	 * Result file 1.
	 */
	@Test
	public void getResult_ReturnReadFalseHiddenTrue_WhenSentPath() {
		criteriaSearch.setExtension("xml");
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyFalse);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with Extension: mp4
	 * ReadOnly true.
	 * Result 0.
     */
	@Test
	public void getResult_Return_WhenSentPath() {
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with Extension: mp4
     * Hidden: True
	 * Result 0.
     */
	@Test
	public void getResult_ReturnFalse_WhenSentPath() {
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with Extension : mp4
	 * Hidden: false.
	 * ReadOnly: true.
	 * Result file 1.
	 */
	@Test
	public void getResult_ReturnReadTrueHiddenFalse_WhenSentPath() {
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyTrue);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyFalse);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with FileName: test
	 * Result 4.
	 */
	@Test
	public void getResult_ReturnFileName_WhenSentPath() {
		criteriaSearch.setFileName("test");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(4, search.search().size());
	}

	/**
	 * Search with CreationDate: 2019-03-29
	 * Result 6.
	 */
	@Test
	public void getResult_ReturnCreationDate_WhenSentPath() {
		criteriaSearch.setCreationDateFrom("2019-03-29");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(6, search.search().size());
	}

	/**
	 * Search with ModificationDate: 2019-03-29
	 * Result 1.
	 */
	@Test
	public void getResult_ReturnModificationDate_WhenSentPath() {
		criteriaSearch.setModificationDateFrom("2019-03-10");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with LastAccessDate: 2019-03-29
	 * Result 6.
	 */
	@Test
	public void getResult_ReturnLastAccessDate_WhenSentPath() {
		criteriaSearch.setLastDateFrom("2019-03-10");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(6, search.search().size());
	}

	/**
	 * Search with LastAccessDate: 2019-03-29
	 * Result 1.
	 */
	@Test
	public void getResult_ReturnSizeMajor_WhenSentPath() {
		int size = 3 * 1023 * 1023;
		criteriaSearch.setSize(Integer.toString(size));
		criteriaSearch.setSizeCompareOption(false);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(1, search.search().size());
	}

	/**
	 * Search with LastAccessDate: 2019-03-29
	 * Result file 5.
	 */
	@Test
	public void getResult_ReturnSizeMinor_WhenSentPath() {
		int size = 3 * 1023 * 1023;
		criteriaSearch.setSize(Integer.toString(size));
		criteriaSearch.setSizeCompareOption(true);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(5, search.search().size());
	}

	/**
	 * Search with LastAccessDate: 2019-03-29
	 * Result file 6.
	 */
	@Test
	public void getResult_ReturnOwner_WhenSentPath() throws IOException {
		Path path = Paths.get("..\\ToolSearch\\src\\test\\java\\com\\jala\\model\\search\\testfiles\\test1.xml");
		UserPrincipal owner = Files.getOwner(path);
		criteriaSearch.setOwner(owner.getName());
		criteriaSearch.setSizeCompareOption(true);
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(6, search.search().size());
	}

	/**
	 * Search with Owner: owner.getName() + "H"
     * @throws IOException
	 * Result file 0.
     */
	@Test
	public void getResult_ReturnOwnerIncorrect_WhenSentPath() throws IOException {
		Path path = Paths.get("..\\ToolSearch\\src\\test\\java\\com\\jala\\model\\search\\testfiles\\test1.xml");
		UserPrincipal owner = Files.getOwner(path);
		criteriaSearch.setOwner(owner.getName() + "H");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with FileName: po
	 * Result file 0
     */

	@Test
	public void getResult_ReturnFilenameIncorrect_WhenSentPath(){
		criteriaSearch.setFileName("po");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with CreationDate: From: "2019-01-15"
     * To: "2019-01-15"
	 * Result zero files
	 */
	@Test
	public void getResult_ReturnCreationDate_WhenSentPathWrongDate() {
		criteriaSearch.setCreationDateFrom("2019-01-15");
		criteriaSearch.setCreationDateTo("2019-01-15");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with ModificationDate: From: "2019-01-15"
     * To: "2019-01-15"
	 * Result 0.
	 */
	@Test
	public void getResult_ReturnModificationDate_WhenSentPathWrongDate() {
		criteriaSearch.setModificationDateFrom("2019-01-15");
		criteriaSearch.setModificationDateTo("2019-01-15");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}

	/**
	 * Search with LastAccessDate: From: "2018-01-15"
     * To: "2018-01-15"
	 * Result 0
	 */
	@Test
	public void getResult_ReturnLastAccessDate_WhenSentPathWrongDate() {
		criteriaSearch.setLastDateFrom("2018-01-15");
		criteriaSearch.setLastDateTo("2018-01-15");
		SearchCommon search = new SearchCommon(criteriaSearch);
		assertEquals(0, search.search().size());
	}
}