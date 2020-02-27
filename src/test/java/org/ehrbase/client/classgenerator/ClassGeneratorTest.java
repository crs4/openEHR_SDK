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

package org.ehrbase.client.classgenerator;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import org.apache.xmlbeans.XmlException;
import org.assertj.core.groups.Tuple;
import org.ehrbase.test_data.operationaltemplate.OperationalTemplateTestData;
import org.junit.Test;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.openehr.schemas.v1.TemplateDocument;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class ClassGeneratorTest {

    public static final String PACKAGE_NAME = "org.ehrbase.client.classgenerator.examples";

    @Test
    public void testGenerate() throws IOException, XmlException {
        OPERATIONALTEMPLATE template = TemplateDocument.Factory.parse(OperationalTemplateTestData.BLOOD_PRESSURE_SIMPLE.getStream()).getTemplate();
        ClassGenerator cut = new ClassGenerator();
        ClassGeneratorResult generate = cut.generate(PACKAGE_NAME, template);


        List<FieldSpec> fieldSpecs = generate.getClasses().values().stream()
                .flatMap(Collection::stream)
                .filter(t -> !t.kind.equals(TypeSpec.Kind.ENUM))
                .map(t -> t.fieldSpecs).flatMap(List::stream).collect(Collectors.toList());


        assertThat(fieldSpecs)
                .extracting(f -> f.name, f -> f.type.toString())
                .containsExactlyInAnyOrder(
                        new Tuple("versionUid", "org.ehrbase.client.openehrclient.VersionUid"),
                        new Tuple("device", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("levelOfExertion", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("commentValue", "java.lang.String"),
                        new Tuple("cuffSizeDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.CuffSizeDefiningcode"),
                        new Tuple("korotkoffSoundsDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.KorotkoffSoundsDefiningcode"),
                        new Tuple("systolicMagnitude", "java.lang.Double"),
                        new Tuple("systolicUnits", "java.lang.String"),
                        new Tuple("diastolicMagnitude", "java.lang.Double"),
                        new Tuple("diastolicUnits", "java.lang.String"),
                        new Tuple("positionDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.PositionDefiningcode"),
                        new Tuple("tiltMagnitude", "java.lang.Double"),
                        new Tuple("tiltUnits", "java.lang.String"),
                        new Tuple("meanArterialPressureMagnitude", "java.lang.Double"),
                        new Tuple("meanArterialPressureUnits", "java.lang.String"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("originValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("pulsePressureMagnitude", "java.lang.Double"),
                        new Tuple("pulsePressureUnits", "java.lang.String"),
                        new Tuple("locationOfMeasurementDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.LocationOfMeasurementDefiningcode"),
                        new Tuple("modelValue", "java.lang.String"),
                        new Tuple("serialNumberValue", "java.lang.String"),
                        new Tuple("dateLastServicedValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("dateLastCalibrationValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("nameValue", "java.lang.String"),
                        new Tuple("descriptionValue", "java.lang.String"),
                        new Tuple("components", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("servicedByValue", "java.lang.String"),
                        new Tuple("manufacturerValue", "java.lang.String"),
                        new Tuple("endTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("healthCareFacility", "com.nedap.archie.rm.generic.PartyIdentified"),
                        new Tuple("composer", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("settingDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode"),
                        new Tuple("territory", "org.ehrbase.client.classgenerator.examples.shareddefinition.Territory"),
                        new Tuple("bloodPressureTrainingSample", "java.util.List<org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.BloodPressureTrainingSampleObservation>"),
                        new Tuple("location", "java.lang.String"),
                        new Tuple("deviceDetailsTrainingSample", "java.util.List<org.ehrbase.client.classgenerator.examples.ehrbasebloodpressuresimpledev0composition.definition.DeviceDetailsTrainingSampleCluster>"),
                        new Tuple("categoryDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode"),
                        new Tuple("startTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("participations", "java.util.List<com.nedap.archie.rm.generic.Participation>")
                );


        //generate.createFiles(Paths.get(".", "src/test/java/"));


    }


    @Test
    public void testGenerateAltEvents() throws IOException, XmlException {
        OPERATIONALTEMPLATE template = TemplateDocument.Factory.parse(OperationalTemplateTestData.ALT_EVENTS.getStream()).getTemplate();
        ClassGenerator cut = new ClassGenerator();
        ClassGeneratorResult generate = cut.generate(PACKAGE_NAME, template);


        List<FieldSpec> fieldSpecs = generate.getClasses().values().stream()
                .flatMap(Collection::stream)
                .filter(t -> !t.kind.equals(TypeSpec.Kind.ENUM))
                .map(t -> t.fieldSpecs).flatMap(List::stream).collect(Collectors.toList());


        assertThat(fieldSpecs)
                .extracting(f -> f.name, f -> f.type.toString())
                .containsExactlyInAnyOrder(
                        new Tuple("value", "java.lang.String"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("gewichtMagnitude", "java.lang.Double"),
                        new Tuple("gewichtUnits", "java.lang.String"),
                        new Tuple("confoundingFactorsEn", "java.util.List<org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.ConfoundingFactorsEnElement>"),
                        new Tuple("commentEnValue", "java.lang.String"),
                        new Tuple("stateOfDressEnDefiningcode", "org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.StateOfDressEnDefiningcode"),
                        new Tuple("value", "java.lang.String"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("gewichtMagnitude", "java.lang.Double"),
                        new Tuple("gewichtUnits", "java.lang.String"),
                        new Tuple("confoundingFactorsEn", "java.util.List<org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.ConfoundingFactorsEnElement>"),
                        new Tuple("commentEnValue", "java.lang.String"),
                        new Tuple("stateOfDressEnDefiningcode", "org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.StateOfDressEnDefiningcode"),
                        new Tuple("value", "java.lang.String"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("gewichtMagnitude", "java.lang.Double"),
                        new Tuple("gewichtUnits", "java.lang.String"),
                        new Tuple("confoundingFactorsEn", "java.util.List<org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.ConfoundingFactorsEnElement>"),
                        new Tuple("widthValue", "java.time.temporal.TemporalAmount"),
                        new Tuple("commentEnValue", "java.lang.String"),
                        new Tuple("stateOfDressEnDefiningcode", "org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.StateOfDressEnDefiningcode"),
                        new Tuple("mathFunctionDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.MathFunctionDefiningcode"),
                        new Tuple("birthEn", "org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.BirthEnEvent"),
                        new Tuple("anyEventEn", "java.util.List<org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.AnyEventEnChoice>"),
                        new Tuple("extensionEn", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("originValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("gerat", "com.nedap.archie.rm.datastructures.Cluster"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("versionUid", "org.ehrbase.client.openehrclient.VersionUid"),
                        new Tuple("endTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("healthCareFacility", "com.nedap.archie.rm.generic.PartyIdentified"),
                        new Tuple("statusValue", "java.lang.String"),
                        new Tuple("berichtIdValue", "java.lang.String"),
                        new Tuple("territory", "org.ehrbase.client.classgenerator.examples.shareddefinition.Territory"),
                        new Tuple("startTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("composer", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("settingDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode"),
                        new Tuple("korpergewicht", "java.util.List<org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition.KorpergewichtObservation>"),
                        new Tuple("erweiterung", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("location", "java.lang.String"),
                        new Tuple("categoryDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode"),
                        new Tuple("participations", "java.util.List<com.nedap.archie.rm.generic.Participation>")
                );

        // generate.createFiles(Paths.get(".", "src/test/java/"));


    }

    @Test
    public void testGenerateEpisode() throws IOException, XmlException {
        OPERATIONALTEMPLATE template = TemplateDocument.Factory.parse(OperationalTemplateTestData.EPISODE_OF_CARE.getStream()).getTemplate();
        ClassGenerator cut = new ClassGenerator();
        ClassGeneratorResult generate = cut.generate(PACKAGE_NAME, template);
        List<FieldSpec> fieldSpecs = generate.getClasses().values().stream()
                .flatMap(Collection::stream)
                .filter(t -> !t.kind.equals(TypeSpec.Kind.ENUM))
                .map(t -> t.fieldSpecs).flatMap(List::stream).collect(Collectors.toList());

        assertThat(fieldSpecs).size().isEqualTo(22);

        //  generate.createFiles(Paths.get(".", "src/test/java/"));


    }

    @Test
    public void testGenerateMultiOccurrence() throws IOException, XmlException {
        OPERATIONALTEMPLATE template = TemplateDocument.Factory.parse(OperationalTemplateTestData.MULTI_OCCURRENCE.getStream()).getTemplate();
        ClassGenerator cut = new ClassGenerator();
        ClassGeneratorResult generate = cut.generate(PACKAGE_NAME, template);


        List<FieldSpec> fieldSpecs = generate.getClasses().values().stream()
                .flatMap(Collection::stream)
                .filter(t -> !t.kind.equals(TypeSpec.Kind.ENUM))
                .map(t -> t.fieldSpecs).flatMap(List::stream).collect(Collectors.toList());


        assertThat(fieldSpecs)
                .extracting(f -> f.name, f -> f.type.toString())
                .containsExactlyInAnyOrder(
                        new Tuple("versionUid", "org.ehrbase.client.openehrclient.VersionUid"),
                        new Tuple("extension", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("settingDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode"),
                        new Tuple("structuredMeasurementLocation", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("originValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("device", "com.nedap.archie.rm.datastructures.Cluster"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("locationOfMeasurementDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.LocationOfMeasurementDefiningcode"),
                        new Tuple("locationOfMeasurementValue", "java.lang.String"),
                        new Tuple("bodyExposureDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyExposureDefiningcode"),
                        new Tuple("bodyExposureValue", "java.lang.String"),
                        new Tuple("temperatureMagnitude", "java.lang.Double"),
                        new Tuple("temperatureUnits", "java.lang.String"),
                        new Tuple("descriptionOfThermalStressValue", "java.lang.String"),
                        new Tuple("exertion", "com.nedap.archie.rm.datastructures.Cluster"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("endTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("healthCareFacility", "com.nedap.archie.rm.generic.PartyIdentified"),
                        new Tuple("composer", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("territory", "org.ehrbase.client.classgenerator.examples.shareddefinition.Territory"),
                        new Tuple("bodyTemperature", "java.util.List<org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyTemperatureObservation>"),
                        new Tuple("location", "java.lang.String"),
                        new Tuple("startTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("currentDayOfMenstrualCycleMagnitude", "java.lang.Long"),
                        new Tuple("environmentalConditions", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("bodyExposure", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyExposureChoice"),
                        new Tuple("locationOfMeasurement", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.LocationOfMeasurementChoice"),
                        new Tuple("categoryDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode"),
                        new Tuple("extension", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("bodyExposureDefiningcode", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyExposureDefiningcode"),
                        new Tuple("bodyExposureValue", "java.lang.String"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("temperatureMagnitude", "java.lang.Double"),
                        new Tuple("temperatureUnits", "java.lang.String"),
                        new Tuple("descriptionOfThermalStressValue", "java.lang.String"),
                        new Tuple("exertion", "com.nedap.archie.rm.datastructures.Cluster"),
                        new Tuple("currentDayOfMenstrualCycleMagnitude", "java.lang.Long"),
                        new Tuple("environmentalConditions", "java.util.List<com.nedap.archie.rm.datastructures.Cluster>"),
                        new Tuple("widthValue", "java.time.temporal.TemporalAmount"),
                        new Tuple("bodyExposure", "org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.BodyExposureChoiceState"),
                        new Tuple("mathFunctionDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.MathFunctionDefiningcode"),
                        new Tuple("anyEvent", "java.util.List<org.ehrbase.client.classgenerator.examples.ehrbasemultioccurrencedev1composition.definition.AnyEventChoice>"),
                        new Tuple("participations", "java.util.List<com.nedap.archie.rm.generic.Participation>")
                );


        //  generate.createFiles(Paths.get(".", "src/test/java/"));

    }

    @Test
    public void testGenerateAllTypes() throws IOException, XmlException {
        OPERATIONALTEMPLATE template = TemplateDocument.Factory.parse(OperationalTemplateTestData.ALL_TYPES.getStream()).getTemplate();
        ClassGenerator cut = new ClassGenerator();
        ClassGeneratorResult generate = cut.generate(PACKAGE_NAME, template);


        List<FieldSpec> fieldSpecs = generate.getClasses().values().stream()
                .flatMap(Collection::stream)
                .filter(t -> !t.kind.equals(TypeSpec.Kind.ENUM))
                .map(t -> t.fieldSpecs).flatMap(List::stream).collect(Collectors.toList());

        assertThat(fieldSpecs)
                .extracting(f -> f.name, f -> f.type.toString())
                .containsExactlyInAnyOrder(
                        new Tuple("versionUid", "org.ehrbase.client.openehrclient.VersionUid"),
                        new Tuple("intervalQuantity", "com.nedap.archie.rm.datavalues.quantity.DvInterval"),
                        new Tuple("text2Value", "java.lang.String"),
                        new Tuple("intervalCount", "com.nedap.archie.rm.datavalues.quantity.DvInterval"),
                        new Tuple("intervalDatetime", "com.nedap.archie.rm.datavalues.quantity.DvInterval"),
                        new Tuple("uriValue", "java.net.URI"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("choice", "org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.ChoiceChoice"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("testAllTypes", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesAction>"),
                        new Tuple("testAllTypesItemsOpenehrEhrInstructionTestAllTypesV1", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesInstruction>"),
                        new Tuple("testAllTypesItemsOpenehrEhrAdminEntryTestAllTypesV1", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesAdminEntry>"),
                        new Tuple("choiceMagnitude", "java.lang.Double"),
                        new Tuple("choiceUnits", "java.lang.String"),
                        new Tuple("choiceMagnitude", "java.lang.Long"),
                        new Tuple("multimediaAny", "com.nedap.archie.rm.datavalues.encapsulated.DvMultimedia"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("parsableAny", "com.nedap.archie.rm.datavalues.encapsulated.DvParsable"),
                        new Tuple("identifier", "com.nedap.archie.rm.datavalues.DvIdentifier"),
                        new Tuple("textValue", "java.lang.String"),
                        new Tuple("codedTextDefiningcode", "com.nedap.archie.rm.datatypes.CodePhrase"),
                        new Tuple("proportionAny", "com.nedap.archie.rm.datavalues.quantity.DvProportion"),
                        new Tuple("timeValueTime", "java.time.temporal.TemporalAccessor"),
                        new Tuple("codedTextTerminologyDefiningcode", "com.nedap.archie.rm.datatypes.CodePhrase"),
                        new Tuple("quantityMagnitude", "java.lang.Double"),
                        new Tuple("quantityUnits", "java.lang.String"),
                        new Tuple("countMagnitude", "java.lang.Long"),
                        new Tuple("dateValue", "java.time.temporal.Temporal"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("originValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("durationAnyValue", "java.time.temporal.TemporalAmount"),
                        new Tuple("ordinal", "com.nedap.archie.rm.datavalues.quantity.DvOrdinal"),
                        new Tuple("booleanValue", "java.lang.Boolean"),
                        new Tuple("datetimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("datetimeAnyValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("testAllTypes", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesCluster>"),
                        new Tuple("endTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("testAllTypesContentOpenehrEhrSectionTestAllTypesV1", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesSection>"),
                        new Tuple("language", "com.nedap.archie.rm.datatypes.CodePhrase"),
                        new Tuple("healthCareFacility", "com.nedap.archie.rm.generic.PartyIdentified"),
                        new Tuple("composer", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("settingDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.SettingDefiningcode"),
                        new Tuple("territory", "org.ehrbase.client.classgenerator.examples.shareddefinition.Territory"),
                        new Tuple("testAllTypesContentOpenehrEhrObservationTestAllTypesV1", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesObservation>"),
                        new Tuple("boolean2Value", "java.lang.Boolean"),
                        new Tuple("transitionDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.TransitionDefiningcode"),
                        new Tuple("transitionDefiningcodeTransition", "org.ehrbase.client.classgenerator.examples.shareddefinition.TransitionDefiningcode"),
                        new Tuple("completedDefiningcodeCurrentState", "org.ehrbase.client.classgenerator.examples.shareddefinition.CompletedDefiningcode"),
                        new Tuple("plannedDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.PlannedDefiningcode"),
                        new Tuple("activeDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.ActiveDefiningcode"),
                        new Tuple("plannedDefiningcodeCareflowStep", "org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.PlannedDefiningcode"),
                        new Tuple("activeDefiningcodeCareflowStep", "org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.ActiveDefiningcode"),
                        new Tuple("transitionDefiningcodeTransitionIsmTransitionAt0003", "org.ehrbase.client.classgenerator.examples.shareddefinition.TransitionDefiningcode"),
                        new Tuple("narrativeValue", "java.lang.String"),
                        new Tuple("description", "com.nedap.archie.rm.datastructures.ItemStructure"),
                        new Tuple("partialDateValue", "java.time.temporal.Temporal"),
                        new Tuple("currentActivity", "java.lang.String"),
                        new Tuple("partialDatetimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("startTimeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("count3Magnitude", "java.lang.Long"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("timeValue", "java.time.temporal.TemporalAccessor"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy"),
                        new Tuple("completedDefiningcode", "org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.CompletedDefiningcode"),
                        new Tuple("testAllTypes", "java.util.List<org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.TestAllTypesEvaluation>"),
                        new Tuple("language", "org.ehrbase.client.classgenerator.examples.shareddefinition.Language"),
                        new Tuple("contextCodedTextDefiningcode", "org.ehrbase.client.classgenerator.examples.testalltypesenv1composition.definition.ContextCodedTextDefiningcode"),
                        new Tuple("categoryDefiningcode", "org.ehrbase.client.classgenerator.examples.shareddefinition.CategoryDefiningcode"),
                        new Tuple("location", "java.lang.String"),
                        new Tuple("participations", "java.util.List<com.nedap.archie.rm.generic.Participation>"),
                        new Tuple("subject", "com.nedap.archie.rm.generic.PartyProxy")
                );


        //    generate.createFiles(Paths.get(".", "src/test/java/"));

    }

    @Test
    public void testCreateName() {
        ClassGenerator cut = new ClassGenerator();
        String className = cut.buildClassName("/_state structure/*_confounding factors(en)_ELEMENT");

        assertThat(className).isEqualTo("ConfoundingFactorsEnElement");
    }

}