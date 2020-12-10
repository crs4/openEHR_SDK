package org.ehrbase.client.classgenerator.exampleoptimizersettingsections.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.EntryEntity;
import org.ehrbase.client.classgenerator.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-EVALUATION.living_arrangement.v0")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2020-12-10T09:57:06.136357300+01:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: null"
)
public class WohnsituationEvaluation implements EntryEntity {
  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/Beschreibung
   */
  @Path("/data[at0001]/items[at0003]/value|value")
  private String beschreibungValue;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/Anzahl der Haushaltsmitglieder
   */
  @Path("/data[at0001]/items[at0007]/value|magnitude")
  private Long anzahlDerHaushaltsmitgliederMagnitude;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/Wohnstätte
   */
  @Path("/data[at0001]/items[openEHR-EHR-CLUSTER.dwelling.v0]")
  private List<WohnstaetteCluster> wohnstaette;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/Erweiterung
   */
  @Path("/protocol[at0002]/items[at0011]")
  private List<Cluster> erweiterung;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/subject
   */
  @Path("/subject")
  private PartyProxy subject;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/language
   */
  @Path("/language")
  private Language language;

  /**
   * Bericht/Allgemeine Angaben/Wohnsituation/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setBeschreibungValue(String beschreibungValue) {
     this.beschreibungValue = beschreibungValue;
  }

  public String getBeschreibungValue() {
     return this.beschreibungValue ;
  }

  public void setAnzahlDerHaushaltsmitgliederMagnitude(Long anzahlDerHaushaltsmitgliederMagnitude) {
     this.anzahlDerHaushaltsmitgliederMagnitude = anzahlDerHaushaltsmitgliederMagnitude;
  }

  public Long getAnzahlDerHaushaltsmitgliederMagnitude() {
     return this.anzahlDerHaushaltsmitgliederMagnitude ;
  }

  public void setWohnstaette(List<WohnstaetteCluster> wohnstaette) {
     this.wohnstaette = wohnstaette;
  }

  public List<WohnstaetteCluster> getWohnstaette() {
     return this.wohnstaette ;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
     this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
     return this.erweiterung ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
