package sif3.au.naplan.consumer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        NAPCodeFrameIT.class,
        NAPEventStudentLinkIT.class,
        NaplanTestDataIT.class,
        NAPStudentResponseSetIT.class,
        NAPTestIT.class,
        NAPTestItemIT.class,
        NAPTestletIT.class,
        NAPTestScoreSummaryIT.class,
        SchoolDataIT.class,
        SchoolInfoIT.class,
        SchoolListIT.class,
        StudentPersonalIT.class
})
public class IntegrationTests {


}
