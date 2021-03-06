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

package org.joinfaces.javaxfaces;

import javax.faces.application.ProjectStage;
import javax.faces.application.ResourceHandler;
import javax.faces.application.StateManager;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.PartialViewContext;
import javax.faces.convert.Converter;
import javax.faces.flow.FlowHandler;
import javax.faces.lifecycle.ClientWindow;
import javax.faces.validator.BeanValidator;
import javax.faces.view.facelets.ResourceResolver;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import lombok.Builder;
import org.joinfaces.ServletContextConfigurer;

/**
 * Servlet Context Configurer of Javax Faces properties.
 * @author Marcelo Fernandes
 */
public class JavaxFacesServletContextConfigurer extends ServletContextConfigurer {

	private JavaxFacesProperties javaxFacesProperties;

	@Builder
	public JavaxFacesServletContextConfigurer(JavaxFacesProperties javaxFacesProperties, ServletContext servletContext) {
		super(servletContext, "");
		this.javaxFacesProperties = javaxFacesProperties;
	}

	@Override
	public void configure() {
		setInitParameterEnum(ProjectStage.PROJECT_STAGE_PARAM_NAME, this.javaxFacesProperties.getProjectStage());

		setInitParameterStringCollection(ResourceHandler.RESOURCE_EXCLUDES_PARAM_NAME, this.javaxFacesProperties.getResourceExcludes(), Separator.SPACE);
		setInitParameterString(ResourceHandler.WEBAPP_CONTRACTS_DIRECTORY_PARAM_NAME, this.javaxFacesProperties.getWebappContractsDirectory());
		setInitParameterString(ResourceHandler.WEBAPP_RESOURCES_DIRECTORY_PARAM_NAME, this.javaxFacesProperties.getWebappResourcesDirectory());

		setInitParameterStringCollection(StateManager.FULL_STATE_SAVING_VIEW_IDS_PARAM_NAME, this.javaxFacesProperties.getFullStateSavingViewIds(), Separator.SEMICOLON);
		setInitParameterBoolean(StateManager.PARTIAL_STATE_SAVING_PARAM_NAME, this.javaxFacesProperties.getPartialStateSaving());
		setInitParameterBoolean(StateManager.SERIALIZE_SERVER_STATE_PARAM_NAME, this.javaxFacesProperties.getSerializeServerState());
		setInitParameterString(StateManager.STATE_SAVING_METHOD_PARAM_NAME, this.javaxFacesProperties.getStateSavingMethod());

		setInitParameterString(ViewHandler.DEFAULT_SUFFIX_PARAM_NAME, this.javaxFacesProperties.getDefaultSuffix());
		setInitParameterBoolean(ViewHandler.DISABLE_FACELET_JSF_VIEWHANDLER_PARAM_NAME, this.javaxFacesProperties.getDisableFaceletJsfViewhandler());
		setInitParameterInteger(ViewHandler.FACELETS_BUFFER_SIZE_PARAM_NAME, this.javaxFacesProperties.getFaceletsBufferSize());
		setInitParameterClassCollection(ViewHandler.FACELETS_DECORATORS_PARAM_NAME, this.javaxFacesProperties.getFaceletsDecorators(), Separator.SEMICOLON);
		setInitParameterStringCollection(ViewHandler.FACELETS_LIBRARIES_PARAM_NAME, this.javaxFacesProperties.getFaceletsLibraries(), Separator.SEMICOLON);
		setInitParameterInteger(ViewHandler.FACELETS_REFRESH_PERIOD_PARAM_NAME, this.javaxFacesProperties.getFaceletsRefreshPeriod());
		setInitParameterBoolean(ViewHandler.FACELETS_SKIP_COMMENTS_PARAM_NAME, this.javaxFacesProperties.getFaceletsSkipComments());
		setInitParameterString(ViewHandler.FACELETS_SUFFIX_PARAM_NAME, this.javaxFacesProperties.getFaceletsSuffix());
		setInitParameterStringCollection(ViewHandler.FACELETS_VIEW_MAPPINGS_PARAM_NAME, this.javaxFacesProperties.getFaceletsViewMappings(), Separator.SEMICOLON);

		setInitParameterBoolean(UIComponent.HONOR_CURRENT_COMPONENT_ATTRIBUTES_PARAM_NAME, this.javaxFacesProperties.getHonorCurrentComponentAttributes());

		setInitParameterString(UIInput.VALIDATE_EMPTY_FIELDS_PARAM_NAME, this.javaxFacesProperties.getValidateEmptyFields());

		setInitParameterString(UINamingContainer.SEPARATOR_CHAR_PARAM_NAME, this.javaxFacesProperties.getSeparatorChar());

		setInitParameterBoolean(PartialViewContext.PARTIAL_EXECUTE_PARAM_NAME, this.javaxFacesProperties.getPartial().getExecute());
		setInitParameterBoolean(PartialViewContext.PARTIAL_RENDER_PARAM_NAME, this.javaxFacesProperties.getPartial().getRender());
		setInitParameterBoolean(PartialViewContext.RESET_VALUES_PARAM_NAME, this.javaxFacesProperties.getPartial().getResetValues());

		setInitParameterBoolean(Converter.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE_PARAM_NAME, this.javaxFacesProperties.getDatetimeconverterDefaultTimezoneIsSystemTimezone());

		setInitParameterBoolean(FlowHandler.NULL_FLOW, this.javaxFacesProperties.getFlow().getNullFlow());

		setInitParameterBoolean(BeanValidator.DISABLE_DEFAULT_BEAN_VALIDATOR_PARAM_NAME, this.javaxFacesProperties.getValidator().getDisableDefaultBeanValidator());

		setInitParameterClass(ResourceResolver.FACELETS_RESOURCE_RESOLVER_PARAM_NAME, this.javaxFacesProperties.getFaceletsResourceResolver());

		setInitParameterStringCollection(FacesServlet.CONFIG_FILES_ATTR, this.javaxFacesProperties.getConfigFiles(), Separator.COMMA);
		setInitParameterString(FacesServlet.LIFECYCLE_ID_ATTR, this.javaxFacesProperties.getLifecycleId());

		setInitParameterString(ClientWindow.CLIENT_WINDOW_MODE_PARAM_NAME, this.javaxFacesProperties.getClientWindowMode());

		setInitParameterBoolean(JavaxFacesProperties.EMPTY_STRING_AS_NULL, this.javaxFacesProperties.getInterpretEmptyStringSubmittedValuesAsNull());

	}
}
