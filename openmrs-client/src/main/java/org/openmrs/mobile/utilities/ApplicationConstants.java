/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.mobile.utilities;

public abstract class ApplicationConstants {
	public static final String EMPTY_STRING = "";
	public static final String SERVER_URL = "server_url";
	public static final String SESSION_TOKEN = "session_id";
	public static final String AUTHORIZATION_TOKEN = "authorisation";
	public static final String SECRET_KEY = "secretKey";
	public static final String LOCATION = "location";
	public static final String PARENT_LOCATION = "parent_location";
	public static final String LOGIN_LOCATIONS = "login_locations";
	public static final String VISIT_TYPE_UUID = "visit_type_uuid";
	public static final String LAST_SESSION_TOKEN = "last_session_id";
	public static final String LAST_LOGIN_SERVER_URL = "last_login_server_url";
	//public static final String DEFAULT_OPEN_MRS_URL = "http://192.168.2.34:9996/openmrs/";
	public static final String DEFAULT_OPEN_MRS_URL = "http://sandbox.openhmisafrica.org/openmrs/";
	public static final String THUMBNAIL_VIEW = "complexdata.view.thumbnail";
	public static final String CIVIL_STATUS = "Civil Status";
	public static final String KIN_RELATIONSHIP = "Kin Relationship";

	public abstract static class OpenMRSSharedPreferenceNames {
		public static final String SHARED_PREFERENCES_NAME = "shared_preferences";
	}

	public abstract static class API {
		public static final String REST_ENDPOINT_V1 = "ws/rest/v1/";
		public static final String REST_ENDPOINT_V2 = "ws/rest/v2/";
		public static final String FULL = "full";
	}

	public abstract static class UserKeys {
		public static final String USER_NAME = "username";
		public static final String PASSWORD = "password";
		public static final String USER_PERSON_NAME = "userDisplay";
		public static final String USER_UUID = "userUUID";
		public static final String LOGIN = "login";
	}

	public abstract static class DialogTAG {
		public static final String AUTH_FAILED_DIALOG_TAG = "authFailedDialog";
		public static final String CONN_TIMEOUT_DIALOG_TAG = "connectionTimeoutDialog";
		public static final String NO_INTERNET_CONN_DIALOG_TAG = "noInternetConnectionDialog";
		public static final String SERVER_UNAVAILABLE_DIALOG_TAG = "serverUnavailableDialog";
		public static final String INVALID_URL_DIALOG_TAG = "invalidURLDialog";
		public static final String LOGOUT_DIALOG_TAG = "logoutDialog";
		public static final String END_VISIT_DIALOG_TAG = "endVisitDialogTag";
		public static final String UNAUTHORIZED_DIALOG_TAG = "unauthorizedDialog";
		public static final String SERVER_ERROR_DIALOG_TAG = "serverErrorDialog";
		public static final String SOCKET_EXCEPTION_DIALOG_TAG = "socketExceptionDialog";
		public static final String SERVER_NOT_SUPPORTED_DIALOG_TAG = "serverNotSupportedDialog";
		public static final String START_VISIT_DIALOG_TAG = "startVisitDialog";
		public static final String START_VISIT_IMPOSSIBLE_DIALOG_TAG = "startVisitImpossibleDialog";
		public static final String WARNING_LOST_DATA_DIALOG_TAG = "warningLostDataDialog";
		public static final String NO_VISIT_DIALOG_TAG = "noVisitDialogTag";
		public static final String SIMILAR_PATIENTS_TAG = "similarPatientsDialogTag";
		public static final String DELET_PATIENT_DIALOG_TAG = "deletePatientDialogTag";
		public static final String ADD_VISIT_TASK_DIALOG_TAG = "addVisitTaskDialogTag";
		public static final String VISIT_NOTE_TAG = "visitNoteTag";
		public static final String PENDING_VISIT_NOTE_CHANGES_TAG = "pendingVisitNoteChangesTag";
	}

	public abstract static class RegisterPatientRequirements {
		public static final int MAX_PATIENT_AGE = 120;
	}

	public abstract static class CustomIntentActions {
		public static final String ACTION_AUTH_FAILED_BROADCAST = "org.openmrs.mobile.intent.action.AUTH_FAILED_BROADCAST";
		public static final String ACTION_UNAUTHORIZED_BROADCAST = "org.openmrs.mobile.intent.action"
				+ ".UNAUTHORIZED_BROADCAST";
		public static final String ACTION_CONN_TIMEOUT_BROADCAST = "org.openmrs.mobile.intent.action"
				+ ".CONN_TIMEOUT_BROADCAST";
		public static final String ACTION_NO_INTERNET_CONNECTION_BROADCAST =
				"org.openmrs.mobile.intent.action.NO_INTERNET_CONNECTION_BROADCAST";
		public static final String ACTION_SERVER_UNAVAILABLE_BROADCAST =
				"org.openmrs.mobile.intent.action.SERVER_UNAVAILABLE_BROADCAST";
		public static final String ACTION_SERVER_ERROR_BROADCAST = "org.openmrs.mobile.intent.action"
				+ ".SERVER_ERROR_BROADCAST";
		public static final String ACTION_SOCKET_EXCEPTION_BROADCAST =
				"org.openmrs.mobile.intent.action.SOCKET_EXCEPTION_BROADCAST";
		public static final String ACTION_SERVER_NOT_SUPPORTED_BROADCAST =
				"org.openmrs.mobile.intent.action.SERVER_NOT_SUPPORTED_BROADCAST";
	}

	public abstract static class EncounterTypeDisplays {
		public static final String VITALS = "Vitals";
		public static final String VISIT_NOTE = "Visit Note";
		public static final String DISCHARGE = "Discharge";
		public static final String ADMISSION = "Admission";
		public static final String AUDITDATA = "Audit Data";
		public static final String AUDIT_DATA_COMPLETENESS = "Audit Data Complete";
	}

	public abstract static class EncounterTypeEntity {
		public static final String VITALS_UUID = "67a71486-1a54-468f-ac3e-7091a9a79584";
		public static final String CLINICAL_NOTE_UUID = "d7151f82-c1f3-4152-a605-2f9ea7414a79";
		public static final String AUDIT_DATA_UUID = "7dc1632c-f947-474f-b92c-7add68019aec";
		public static final String VISIT_NOTE_FORM_ID = "17";
	}

	public abstract static class ObservationLocators {
		public static final String CLINICAL_NOTE = "Text of encounter note";
		public static final String DIAGNOSES = "Visit Diagnoses";
		public static final String PRIMARY_DIAGNOSIS = "Primary";
		public static final String SECONDARY_DIAGNOSIS = "Secondary";
		public static final String PRESUMED_DIAGNOSIS = "Presumed diagnosis";
		public static final String CONFIRMED_DIAGNOSIS = "Confirmed diagnosis";
		public static final String CHIEF_COMPLAINT = "Chief complaint";
	}

	public abstract static class DiagnosisStrings {
		public static final String PRIMARY_ORDER = "PRIMARY";
		public static final String SECONDARY_ORDER = "SECONDARY";
		public static final String CONFIRMED = "CONFIRMED";
		public static final String PRESUMED = "PRESUMED";
		public static final String NON_CODED = "Non-Coded:";
		public static final String CONCEPT_UUID = "ConceptUuid:";
	}

	public abstract static class BundleKeys {
		public static final String CUSTOM_DIALOG_BUNDLE = "customDialogBundle";
		public static final String PATIENT_UUID_BUNDLE = "patientUUID";
		public static final String VISIT_UUID_BUNDLE = "visitUUID";
		public static final String END_VISIT = "endVisit";
		public static final String PROVIDER_UUID_BUNDLE = "providerUUID";
		public static final String EncounterTypeEntity = "EncounterTypeEntity";
		public static final String VALUEREFERENCE = "valueReference";
		public static final String FORM_NAME = "formName";
		public static final String CALCULATED_LOCALLY = "CALCULATED_LOCALLY";
		public static final String PATIENTS_AND_MATCHES = "PATIENTS_AND_MATCHES";
		public static final String FORM_FIELDS_BUNDLE = "formFieldsBundle";
		public static final String FORM_FIELDS_LIST_BUNDLE = "formFieldsListBundle";
		public static final String PATIENT_QUERY_BUNDLE = "patientQuery";
		public static final String OBSERVATION = "observationTag";
		public static final String VISIT = "visitTag";
		public static final String VISIT_CLOSED_DATE = "visitClosedDate";
		public static final String AUDIT_DATA_AVAILABILITY = "auditDataAvailability";
		public static final String LOCATION_UUID_BUNDLE = "locationUuid";
	}

	public static class ConceptSets {
		public static final String ICPC_DIAGNOSES = "160167AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	}

	public static class toastMessages {
		public static final String addErrorMessage = " could not be added";
		public static final String addWarningMessage = " could not be added";
		public static final String addSuccessMessage = " was added successfully";
		public static final String updateErrorMessage = " could not be updated";
		public static final String updateWarningMessage = " could not be updated";
		public static final String updateSuccessMessage = " update successfully";
		public static final String fetchErrorMessage = " could not be fetched";
		public static final String fetchWarningMessage = " could not be fetched";
		public static final String fetchSuccessMessage = " were loaded successfully";
	}

	public static class entityName {
		public static final String VISIT_TASKS = "Visit Task(s)";
		public static final String PATIENTS = "Patient(s)";
		public static final String LAST_VIEWED_PATIENT = "Last Viewed Patient(s)";
		public static final String CIVIL_STATUS = "Civil Status";
		public static final String ATTRIBUTE_TPYES = "Attribute Type(s)";
		public static final String IDENTIFIER_TPYES = "Identifier Type(s)";
		public static final String PREDEFINED_TASKS = "Predefined task(s)";
		public static final String VISITS = "Visit(s)";
		public static final String LOCATION = "Location(s)";
		public static final String COUNTY = "county";
		public static final String SUBCOUNTY = "sub-county";
		public static final String TELEPHONE = "telephonenumber";
	}

	public static class unwantedPersonAttributes {
		public static final String BIRTH_PLACE_UUID = "8d8718c2-c2cc-11de-8d13-0010c6dffd0f";
		public static final String HEALTH_CENTER_UUID = "8d87236c-c2cc-11de-8d13-0010c6dffd0f";
		public static final String HEALTH_DISTRICT_UUID = "8d872150-c2cc-11de-8d13-0010c6dffd0f";
		public static final String MOTHER_NAME_UUID = "8d871d18-c2cc-11de-8d13-0010c6dffd0f";
		public static final String RACE_UUID = "8d871386-c2cc-11de-8d13-0010c6dffd0f";
		public static final String UNKNOWN_PATIENT_UUID = "8b56eac7-5c76-4b9c-8c6f-1deab8d3fc47";
		public static final String TEST_PATIENT_UUID = "4f07985c-88a5-4abd-aa0c-f3ec8324d8e7";
	}

	public abstract static class FORM_UUIDS {
		public static final String AUDIT_DATA_FORM_UUID = "667dc18e-740f-44ce-ae0a-5ba6b33308b0";
		public static final String VITALS_FORM_UUID = "a000cb34-9ec1-4344-a1c8-f692232f6edd";
		public static final String CLINICAL_FORM_UUID = "6d071264-3932-41fe-95f2-1dbbf2e4cd31";
		public static final String VISIT_NOTE_HTML_FORM_ID = "17";
	}

	public abstract static class AuditFormAnswers {
		public static final String ANSWER_YES = "yes";
		public static final String ANSWER_NO = "no";
		public static final String ANSWER_UNKNOWN = "unknown";
		public static final String ANSWER_NA = "Not applicable";
		public static final String ANSWER_PLANNED = "Planned (scheduled in clinic)";
		public static final String ANSWER_UNPLANNED = "Unplanned (not scheduled in clinic)";
		public static final String ANSWER_NEGATIVE = "NEGATIVE";
		public static final String ANSWER_POSITIVE = "POSITIVE";
	}

	public abstract static class AuditFormConcepts {
		public static final String CONCEPT_ANSWER_YES = "1065AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_ANSWER_NO = "1066AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_ANSWER_UNKNOWN = "1067AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_ANSWER_PLANNED = "1d8dc2abe-d5a5-44b1-9dc6-809a993a8dbc";
		public static final String CONCEPT_ANSWER_UNPLANNED = "1680114c-72b9-44d7-a292-f2c981322587";
		public static final String CONCEPT_ANSWER_NA = "1175AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_ANSWER_NEGATIVE = "664AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_ANSWER_POSITIVE = "703AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_DEATH_IN_HOSPITAL = "ec559b53-8cc9-4b54-a34e-95a605919365";
		public static final String CONCEPT_PALLIATIVE_CONSULT = "a9ae21a2-2631-49d6-928c-d23001812729";
		public static final String CONCEPT_PREOP_RISK_ASSESMENT = "eadfe47c-7988-42ea-97d0-e21ce71db7e0";
		public static final String CONCEPT_ICU_STAY = "9446f7aa-7a1c-4246-a0a5-1ebc3560a0e0";
		public static final String CONCEPT_HDU_STAY = "46d4283e-3275-4c6e-9d52-cfd858889f4b";
		public static final String CONCEPT_HDU_COMGMT = "dd61d87f-3398-46c2-8108-00db2e49bab6";
		public static final String CONCEPT_HIV_STATUS = "1169AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_CD4_COUNT = "5497AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_HBA1C = "159644AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_INPATIENT_SERVICE_TYPE = "161630AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_AUDIT_COMPLETE = "98f0f043-bdb1-40c6-8c81-6a094056e981";
		public static final String CONCEPT_MECHANICAL_VENTILATIN = "99f47aa5-827c-4472-9884-fbbc094f70bd";
		public static final String CONCEPT_RECIEVED_VAOSPRESSORS = "611cfa95-0685-4c76-bf9c-981647a085e6";
		public static final String CONCEPT_SURGERY_HOSPITAL_STAY = "8b1d25f9-2f2e-4dfa-a5a1-87e2f7a3bb52";
		public static final String CONCEPT_INFECTION_CONFIRMED_SUSPECTED = "8284a6a3-0445-4a23-96cd-8c6767397051";
		public static final String CONCEPT_FIRST_SBP_ICU = "8f7ad9c2-aca6-458e-9362-963b4d391a7c";
		public static final String CONCEPT_FIRST_MAP_ICU = "0b19946c-63a6-41e8-b3af-a87fc6addab4";
		public static final String CONCEPT_FIRST_HEART_RATE_ICU = "9360b4f4-4456-4bc2-97fd-68e661a19d78";
		public static final String CONCEPT_FIRST_GCS_SCORE_ICU = "99659fa6-fe39-41d7-ac6b-f183d9231310";
		public static final String CONCEPT_SEDETION_PRIOR_FIRST_GCS_SCORE_ICU = "7cccf308-edca-4c3e-afde-e7a3f1155ec6";
		public static final String CONCEPT_PATIENT_DIABETIC = "a424ed50-5f94-4296-a91c-73ebbc1ccca1";
		public static final String CONCEPT_WARD_STAY_DURING_ADMISSION = "59073230-e0d9-4cbc-bebc-4bf91a42f3bb";
	}

	public abstract static class VITALSFormConcepts {
		public static final String CONCEPT_HEIGHT = "5090AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_WEIGHT = "5089AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_TEMPERATURE = "5088AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_PULSE = "5087AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_RESPIRATORY_RATE = "5242AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_BLOOD_PRESSURE_SYSTOLIC = "5085AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_BLOOD_PRESSURE_DIASTOLIC = "5086AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		public static final String CONCEPT_BLOOD_OXYGEN_SATURATION = "5092AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	}

	public abstract static class ClinicalFormConcepts {
		public static final String ClinicFormUUID = "162169AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	}

	public static class visitAttributeTypes {
		public static final String PERSON_ATTRIBUTE_TYPE_PHONE_NUMBER = "14d4f066-15f5-102d-96e4-000c29c2a5d7";
	}

	public static class ValidationFieldValues {
		public static int VITALS_HEIGHT_MIN = 10;
		public static int VITALS_HEIGHT_MAX = 272;

		public static int VITALS_WEIGHT_MIN = 0;
		public static int VITALS_WEIGHT_MAX = 250;

		public static int VITALS_TEMPERATURE_MIN = 25;
		public static int VITALS_TEMPERATURE_MAX = 43;

		public static int VITALS_PULSE_MIN = 0;
		public static int VITALS_PULSE_MAX = 230;

		public static int VITALS_RESPIRATORYRATE_MIN = 0;
		public static int VITALS_RESPIRATORYRATE_MAX = 999;

		public static int VITALS_SYSTOLICBP_MIN = 50;
		public static int VITALS_SYSTOLICBP_MAX = 250;

		public static int VITALS_DIASTOLICBP_MIN = 30;
		public static int VITALS_DIASTOLICBP_MAX = 150;

		public static int VITALS_BLOOD_OXYGEN_MIN = 0;
		public static int VITALS_BLOOD_OXYGEN_MAX = 100;

		public static int AUDIT_GCS_SCORE_MIN = 3;
		public static int AUDIT_GCS_SCORE_MAX = 15;
	}

	public static class CacheKays {
		public static final String VISIT_ATTRIBUTE_TYPE = "visitAttributeType";
		public static final String PERSON_ATTRIBUTE_TYPE = "personAttributeType";
		public static final String PERSON_IDENTIFIER_TYPE = "personIdentifierType";
		public static final String VISIT_TYPE = "visitType";
	}

	public class ErrorCodes {
		public static final int INVALID_URL = 100;
		public static final int INVALID_USERNAME_PASSWORD = 101;
		public static final int SERVER_ERROR = 102;
		public static final int OFFLINE_LOGIN = 103;
		public static final int AUTH_FAILED = 104;
		public static final int OFFLINE_LOGIN_UNSUPPORTED = 105;
		public static final int NO_INTERNET = 106;
		public static final int USER_NOT_FOUND = 107;
		public static final int LOGOUT_DUE_TO_INACTIVITY = 108;

	}

	public static class ConceptSource {
		public static final String ICD_10_WHO = "ICD-10-WHO";
	}
}
