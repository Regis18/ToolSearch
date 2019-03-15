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

package com.jala.search.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchCommonTest {

    @Test
    public void getResult_ReturnPaths_WhenSentPath() {
        CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Usuario\\Desktop\\JALA\\Prog02");
        SearchCommon search = new SearchCommon(criteriaSearch);
        for (int i = 0; i < search.search().size(); i++) {
            System.out.println(search.search().get(i).getPath());
        }
    }
    @Test
    public void getResult_ReturnPaths_WhenSentOnlyMP4() {
        CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
        criteriaSearch.setExtension("mp4");
        SearchCommon search = new SearchCommon(criteriaSearch);
        for (int i = 0; i < search.search().size(); i++) {
            System.out.println(search.search().get(i).getPath());
        }
    }
}