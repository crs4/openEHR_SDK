package org.ehrbase.client.classgenerator.exampleoptimizersettingsections.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2020-12-10T09:57:05.997359500+01:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: null"
)
public interface GeschichteHistorieBeliebigesEreignisChoice {
  List<GeschichteHistorieGeschichteElement> getGeschichte();

  void setGeschichte(List<GeschichteHistorieGeschichteElement> geschichte);

  FeederAudit getFeederAudit();

  void setFeederAudit(FeederAudit feederAudit);

  TemporalAccessor getTimeValue();

  void setTimeValue(TemporalAccessor timeValue);

  List<Cluster> getStrukturierteAngabe();

  void setStrukturierteAngabe(List<Cluster> strukturierteAngabe);
}
