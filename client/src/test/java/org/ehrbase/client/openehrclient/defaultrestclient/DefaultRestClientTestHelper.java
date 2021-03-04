/*
 *  Copyright (c) 2019  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *  This file is part of Project EHRbase
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.ehrbase.client.openehrclient.defaultrestclient;

import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.templateprovider.TestDataTemplateProvider;

import java.net.URI;
import java.net.URISyntaxException;

public class DefaultRestClientTestHelper {

  private static final String OPEN_EHR_URL = "http://localhost:8080/ehrbase/rest/openehr/v1/";

  public static DefaultRestClient setupDefaultRestClient() throws URISyntaxException {
    TestDataTemplateProvider templateProvider = new TestDataTemplateProvider();
    DefaultRestClient client = new DefaultRestClient(new OpenEhrClientConfig(new URI(OPEN_EHR_URL)),
        templateProvider);
    templateProvider.listTemplateIds().stream()
        .forEach(t -> client.templateEndpoint().ensureExistence(t));
    return client;
  }

  public static DefaultRestClient setupRestClientWithDefaultTemplateProvider()
      throws URISyntaxException {
    return new DefaultRestClient(new OpenEhrClientConfig(new URI(OPEN_EHR_URL)));
  }
}