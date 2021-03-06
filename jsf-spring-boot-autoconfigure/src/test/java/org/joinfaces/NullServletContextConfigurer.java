/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces;

import javax.faces.application.ProjectStage;
import javax.servlet.ServletContext;

import lombok.Builder;

public class NullServletContextConfigurer extends ServletContextConfigurer {

	@Builder
	public NullServletContextConfigurer(ServletContext servletContext) {
		super(servletContext, null);
	}

	@Override
	public void configure() {
		setInitParameterString(null, "");
		setInitParameterString("string", null);
		setInitParameterBoolean(null, Boolean.TRUE);
		setInitParameterBoolean("boolean", null);
		setInitParameterInteger(null, 10);
		setInitParameterInteger("integer", null);
		setInitParameterLong(null, 10L);
		setInitParameterLong("long", null);
		setInitParameterEnum(null, ProjectStage.Development);
		setInitParameterEnum("enum", null);
	}
}
