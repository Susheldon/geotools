/*
 * GeoTools - The Open Source Java GIS Toolkit
 * http://geotools.org
 *
 * (C) 2016, Open Source Geospatial Foundation (OSGeo)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */

package org.geotools.gce.imagemosaic.geomhandler;

import org.geotools.coverage.grid.io.GridCoverage2DReader;
import org.geotools.coverage.grid.io.StructuredGridCoverage2DReader;
import org.geotools.gce.imagemosaic.MosaicConfigurationBean;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

/**
 * Handle setting the geometry of the index feature for incoming granules
 */
public interface GranuleGeometryHandler {

    /**
     * Handle the case of a regular grid coverage being added to the mosaic. In the default case
     * this is generally just taking the envelope from the coverage and adding it to the target
     * feature.
     * @param inputReader input reader of the incoming granule
     * @param feature target index feature
     * @param indexSchema schema of the index
     * @param mosaicConfigurationBean the mosaic configuration
     */
    void handleGeometry(GridCoverage2DReader inputReader, SimpleFeature feature,
            SimpleFeatureType indexSchema, MosaicConfigurationBean mosaicConfigurationBean);

    /**
     * Handle the case of a structured grid coverage being added to the mosaic. In the default case
     * this is just copying the geometry feature from the incoming granule.
     *
     * @param inputReader input reader of the incoming granule
     * @param targetFeature the target index feature
     * @param targetFeatureType the index schema
     * @param inputFeature the incoming granule feature
     * @param inputFeatureType the incoming coverage schema
     * @param mosaicConfiguration the mosaic configuration
     */
    void handleGeometry(
            StructuredGridCoverage2DReader inputReader,
            SimpleFeature targetFeature,
            SimpleFeatureType targetFeatureType,
            SimpleFeature inputFeature,
            SimpleFeatureType inputFeatureType,
            MosaicConfigurationBean mosaicConfiguration);
}
