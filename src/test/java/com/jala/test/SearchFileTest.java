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

import com.jala.model.search.SearchFile;
import com.jala.model.search.asset.Asset;
import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.search.TernaryBooleanEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
     * Test the correct filename is returned.
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
     * Test the correct extension is returned.
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
     * Test return the first hidden and not hidden file.
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
     * Test return the first file read only.
     */
    @Test
    public void searchHiddenOnlyTrue() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setReadOnly(TernaryBooleanEnum.OnlyTrue);
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(0, assetList.size());
    }

    /**
     * Test return the number of files, readOnly  and not readOnly files.
     */
    @Test
    public void searchReadOnlyAll() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Windows\\System32\\drivers\\etc");
        cr.setReadOnly(TernaryBooleanEnum.ALL);
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(5, assetList.size());
    }

    /**
     * Test return the number of files, with correct owner.
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
     * Test return the number of files with the same size.
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
     * Test return number the file with size equal to zero.
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
     * Test return the number of file with the a creation date.
     */
    @Test
    public void searchCreationDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setCreationDateFrom("2019-03-14");
        cr.setCreationDateTo("2019-03-14");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(2, assetList.size());
    }

    /**
     * Test return the number of file with the a modification date.
     */
    @Test
    public void searchModificationDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setModificationDateFrom("2019-03-01");
        cr.setModificationDateTo("2019-03-03");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }

    /**
     * Test return the number of file with the a last date.
     */
    @Test
    public void searchLastDate() {
        CriteriaSearch cr = new CriteriaSearch("c:\\Search");
        cr.setLastDateFrom("2019-03-01");
        cr.setLastDateTo("2019-03-03");
        SearchFile sf = new SearchFile();
        List<Asset> assetList = sf.search(cr);
        assertEquals(3, assetList.size());
    }
}
