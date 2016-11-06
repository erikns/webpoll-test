package no.hib.megagruppe.webpoll.services;

import java.sql.Timestamp;
import java.util.List;

import no.hib.megagruppe.webpoll.models.lecturer.SurveyBasicInfoModel;
import no.hib.megagruppe.webpoll.models.lecturer.SurveyOverviewModel;
import no.hib.megagruppe.webpoll.models.lecturer.SurveyResultModel;

/**
 * Interface to support the use cases of the lecturer editing / viewing surveys.
 * Note: this service assumes nothing about security, and expects the checking of
 * user credentials etc to be done before any service method is called.
 */
public interface SurveyOverviewService {
    // NOTES:
    // Create
    // Clone
    // See results
	
	/**
	 * Returns all the surveys belonging to the logged in user.
	 * @return All the lecturers surveys represented as a list of SurveryOverviewModels
	 */
    List<SurveyBasicInfoModel> getSurveyOverviews();
    
    /**
     * Clones the survey with the provided survey ID as a new survey
     * @param surveyID The ID of the survey to be cloned
     * @return Returns false if no survey with the provide surveyID exists
     */
    Boolean cloneSurvey(Integer surveyID);
    
    SurveyOverviewModel getSurveyOverviewModel(Integer id);

    SurveyResultModel getSurveyResult(Integer id);
    
    void activateSurvey(Timestamp deadline, Integer surveyID);
}
