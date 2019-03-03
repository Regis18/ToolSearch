/*
 * @(#) SearchFileTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.test;

import com.jala.search.models.Asset;
import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;
import com.jala.search.models.TernaryBooleanEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.List;

import static org.junit.Assert.*;

public class SearchFileTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     *
     */
    @Test
    public void searchFileName() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setFileName("hosts");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals("c:\\Windows\\System32\\drivers\\etc\\hosts", assetList.get(0).getPath());
    }

    /**
     *
     */
    @Test
    public void searchExtension() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setExtension("sam");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals("c:\\Windows\\System32\\drivers\\etc\\lmhosts.sam", assetList.get(0).getPath());
    }

    /**
     *
     */
    @Test
    public void searchHiddenAll() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setHidden(TernaryBooleanEnum.ALL);
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals("c:\\Windows\\System32\\drivers\\etc\\hosts", assetList.get(0).getPath());
    }

    /**
     *
     */
    @Test
    public void searchHiddenOnlyTrue() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setHidden(TernaryBooleanEnum.OnlyTrue);
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(0, assetList.size());
    }

    /**
     *
     */
    @Test
    public void searchReadOnlyAll() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setReadonly(TernaryBooleanEnum.ALL);
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(5, assetList.size());
    }

    /**
     *
     */
   @Test
    public void searchOwner() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setOwner("LAPTOP-B31P03EN\\Melvi");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }

    /**
     *
     */
   @Test
    public void searchSize() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setSize("9.0");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(1, assetList.size());
    }

    /**
     *
     */
    @Test
    public void searchSizeCero() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setSize("0.0");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(2, assetList.size());
    }

    /**
     *
     */
    @Test
    public void searchCreationDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setCreationDate("2019-03-02");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }

    /**
     *
     */
    @Test
    public void searchModificationDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setModificationDate("2019-03-02");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }

    /**
     *
     */
    @Test
    public void searchLastDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setLastDate("2019-03-02");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }
}
