/**
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license,
 * available at the root application directory.
 */

package org.fao.geonet.jackson.databind.geojson;

import com.fasterxml.jackson.databind.Module;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot {@link EnableAutoConfiguration @EnableAutoConfiguration} to
 * register GeoTools and jackson databind {@link Module modules}.
 *
 * <p>
 * Configuration enablement is conditional on the presence of
 * {@link GeoToolsFilterModule} on the classpath. Add an explicit dependency on
 * {@code gs-cloud-catalog-support:gt-jackson-bindings} to use it.
 *
 * <p>
 * Spring-boot's default auto configuration does not register all modules in the
 * classpath, despite them being register-able through Jackson's SPI; a
 * configuration like this is needed to set up the application required ones.
 */
@Configuration
public class JtsGeoJsonJacksonBindingsAutoConfiguration {

  public @Bean JtsGeoJsonModule jtsGeoJsonModule() {
    return new JtsGeoJsonModule();
  }

  public @Bean GeoRecordToGeoJsonFeatureModule geoRecordToGeoJsonFeatureModule() {
    return new GeoRecordToGeoJsonFeatureModule();
  }
}
