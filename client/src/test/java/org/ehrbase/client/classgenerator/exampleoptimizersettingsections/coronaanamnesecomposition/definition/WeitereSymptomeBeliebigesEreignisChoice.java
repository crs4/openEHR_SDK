package org.ehrbase.client.classgenerator.exampleoptimizersettingsections.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2020-12-10T09:57:06.071356700+01:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: null"
)
public interface WeitereSymptomeBeliebigesEreignisChoice {
  FeederAudit getFeederAudit();

  void setFeederAudit(FeederAudit feederAudit);

  TemporalAccessor getTimeValue();

  void setTimeValue(TemporalAccessor timeValue);

  List<WeitereSymptomeSpezifischesSymptomAnzeichenCluster> getSpezifischesSymptomAnzeichen();

  void setSpezifischesSymptomAnzeichen(
      List<WeitereSymptomeSpezifischesSymptomAnzeichenCluster> spezifischesSymptomAnzeichen);
}
