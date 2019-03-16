/*
 * @(#) ISearchable.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.search.assetFile.Asset;
import com.jala.model.criteria.CriteriaSearch;

import java.util.List;

/**
 * ISearchable interface to search by criteria.
 * @version 0.0.1
 * @author Areliez Vargas
 */
public interface ISearchable {

    /**
     * This method search the files of a directory by criteria.
     * It should not be called without first have the path criteria.
     * @param criteria to do the search.
     * @return a list of files of a directory.
     */
    List<Asset> search(CriteriaSearch criteria);
}
