package sif3.au.naplan.sif;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif.dd.au30.model.NAPTestType;
import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.au.naplan.api.model.NaplanResponse;
import sif3.au.naplan.conversion.DataModelMarshaller;
import sif3.au.naplan.conversion.DataModelUnmarshaller;
import sif3.au.naplan.conversion.NaplanResponseMarshaller;
import sif3.au.naplan.conversion.NaplanResponseUnmarshaller;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;

// This is pretending to be an enum so that we can use generics.
public class SIFObjectInfo<SE, SC> {

    // @formatter:off
    // Basic XML Providers
    public static final SIFObjectInfo<NaplanResponse, NaplanResponse> SchoolData = new SIFObjectInfo<>(ObjectType.SchoolData, NaplanResponse.class, NaplanResponse.class);
    public static final SIFObjectInfo<NaplanResponse, NaplanResponse> SchoolList = new SIFObjectInfo<>(ObjectType.SchoolList, NaplanResponse.class, NaplanResponse.class);
    public static final SIFObjectInfo<NaplanResponse, NaplanResponse> TestData = new SIFObjectInfo<>(ObjectType.TestData, NaplanResponse.class, NaplanResponse.class);
    // SIF Providers
    public static final SIFObjectInfo<SchoolInfoType, SchoolInfoCollectionType> SchoolInfo = new SIFObjectInfo<>(ObjectType.SchoolInfo, SchoolInfoType.class, SchoolInfoCollectionType.class);
    public static final SIFObjectInfo<NAPCodeFrameType, NAPCodeFrameCollectionType> NAPCodeFrame = new SIFObjectInfo<>(ObjectType.NAPCodeFrame, NAPCodeFrameType.class, NAPCodeFrameCollectionType.class);
    public static final SIFObjectInfo<NAPTestType, NAPTestCollectionType> NAPTest = new SIFObjectInfo<>(ObjectType.NAPTest, NAPTestType.class, NAPTestCollectionType.class);
    public static final SIFObjectInfo<NAPTestletType, NAPTestletCollectionType> NAPTestlet = new SIFObjectInfo<>(ObjectType.NAPTestlet, NAPTestletType.class, NAPTestletCollectionType.class);
    public static final SIFObjectInfo<NAPTestItemType, NAPTestItemCollectionType> NAPTestItem = new SIFObjectInfo<>(ObjectType.NAPTestItem, NAPTestItemType.class, NAPTestItemCollectionType.class);
    public static final SIFObjectInfo<StudentPersonalType, StudentPersonalCollectionType> StudentPersonal = new SIFObjectInfo<>(ObjectType.StudentPersonal, StudentPersonalType.class, StudentPersonalCollectionType.class);
    public static final SIFObjectInfo<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> NAPEventStudentLink = new SIFObjectInfo<>(ObjectType.NAPEventStudentLink, NAPEventStudentLinkType.class, NAPEventStudentLinkCollectionType.class);
    public static final SIFObjectInfo<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> NAPStudentResponseSet = new SIFObjectInfo<>(ObjectType.NAPStudentResponseSet, NAPStudentResponseSetType.class, NAPStudentResponseSetCollectionType.class);
    public static final SIFObjectInfo<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> NAPTestScoreSummary = new SIFObjectInfo<>(ObjectType.NAPTestScoreSummary, NAPTestScoreSummaryType.class, NAPTestScoreSummaryCollectionType.class);
    // @formatter:on
    

    public ObjectType objectType;
    public String objectName;
    public String collectionName;
    public Class<SE> objectClass;
    public Class<SC> collectionClass;
    public ModelObjectInfo singleObjectInfo;
    public ModelObjectInfo multiObjectInfo;
    public MarshalFactory marshaller;
    public UnmarshalFactory unmarshaller;
    public DataModelUnmarshaller typedUnmarshaller;

    private SIFObjectInfo(ObjectType objectType, Class<SE> objectClass, Class<SC> collectionClass) {
        this.objectName = objectType.toString();
        if (NaplanResponse.class.isAssignableFrom(collectionClass)) {
            marshaller = new NaplanResponseMarshaller();
            unmarshaller = new NaplanResponseUnmarshaller();
            typedUnmarshaller = null;
            this.collectionName = objectName;
        } else {
            marshaller = new DataModelMarshaller();
            typedUnmarshaller = new DataModelUnmarshaller();
            unmarshaller = typedUnmarshaller;
            this.collectionName = objectName + "s";
            CollectionHelper.assignCollectionMethod(collectionClass, this.objectName);
            ObjectFactoryHelper.assignCreateMethod(objectClass, this.objectName);
            ObjectFactoryHelper.assignCreateMethod(collectionClass, this.collectionName);
        }
        this.objectType = objectType;
        this.objectClass = objectClass;
        this.collectionClass = collectionClass;
        this.singleObjectInfo = new ModelObjectInfo(objectName, objectClass);
        this.multiObjectInfo = new ModelObjectInfo(collectionName, collectionClass);
    }

    public static void initialise() {
        // static initialisation.
    }

}
