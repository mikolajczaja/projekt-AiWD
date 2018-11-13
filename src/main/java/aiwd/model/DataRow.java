package aiwd.model;

import aiwd.util.ParsingUtil;

import java.util.List;

public class DataRow {

    private String id;
    private Boolean female;
    private Integer age;
    private Boolean paroxysmalAtrialFibrillation;    //(napadowe migotanie przedsionków)
    private Boolean persistentAtrialFibrillation;    //(przetrwale)
    private Boolean chronicAtrialFibrillation;   //(utrwalone)
    private Boolean over75;
    private Boolean between65and74;
    private Boolean arterialHypertension;
    private Boolean diabetesType2Insulin;
    private Boolean diabetesType2OralMedication;
    private Boolean diabetesType2Diet;
    private Boolean pnspEF;
    private Boolean pnsrEF;
    private Boolean psnmEF;
    private Boolean pastHeartAttacks;
    private Boolean pastStrokesOrTIA;
    private Integer weight;
    private Boolean nicotineSmoking;
    private String heartRate;
    private Boolean heartAttackDuringHospitalization;
    private Boolean activeInfectionDuringHospitalization;
    private List<Double> creatinine;
    private String eGFR;
    private String pchnLevel;
    private List<Double> tsh;
    private List<Double> alat;
    private List<Double> aspat;
    private List<Double> bilirubin;
    private Boolean steroids;
    private Boolean alcoholDrinking;
    private Boolean pastHemorrhage;
    private List<Double> crp;
    private List<Integer> thrombocytes;
    private List<Double> hemoglobin;
    private List<Integer> sodium;
    private List<Double> potassium;
    private List<Integer> ntProBNP;
    private List<Double> cholesterol;
    private List<Double> ldl;
    private List<Double> hdl;
    private List<Integer> triglicerides;
    private Double lvedd;
    private Double rvedd;
    private Double lad;
    private Double ladCC;
    private Double lvef;
    private Double ivsd;
    private Double lvpwd;
    private Double lvmi;
    private Double e;
    private Double a;
    private Double decT;
    private Double eaRatio;
    private Double eemRatio;
    private String disfunctionLevel;
    private Integer tapse;
    private Integer mapse;
    private Boolean asa;
    private Boolean clopidogrel;
    private Boolean ticagrelor;
    private Boolean vka;
    private Boolean noac;
    private Boolean noacReduced;
    private Boolean hdcz;
    private Boolean noTreatment;
    private Boolean statins;
    private Boolean aceinhAT1;
    private Boolean bBlocker;
    private Boolean diuretics;  //leki moczopedne
    private Boolean mcraSpironol;
    private Boolean caBlocker;
    private Boolean alphaBlocker;
    private Boolean antibiotics;
    private Boolean inhaledPOCHP;
    private Boolean antiarhythmic;

    public DataRow(String[] csvRow) {
        this.id = csvRow[0];
        this.female = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[2]);
        this.age = ParsingUtil.parseIntegerIgnoringEmptyString(csvRow[3]);
        this.paroxysmalAtrialFibrillation = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[4]);
        this.persistentAtrialFibrillation = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[5]);
        this.chronicAtrialFibrillation = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[6]);
        this.over75 = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[7]);
        this.between65and74 = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[8]);
        this.arterialHypertension = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[9]);
        this.diabetesType2Insulin = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[10]);
        this.diabetesType2OralMedication = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[11]);
        this.diabetesType2Diet = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[12]);
        this.pnspEF = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[13]);
        this.pnsrEF = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[14]);
        this.psnmEF = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[15]);
        this.pastHeartAttacks = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[16]);
        this.pastStrokesOrTIA = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[17]);
        this.weight = ParsingUtil.parseIntegerIgnoringEmptyString(csvRow[18]);
        this.nicotineSmoking = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[19]);
        this.heartRate = csvRow[20];
        this.heartAttackDuringHospitalization = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[21]);
        this.activeInfectionDuringHospitalization = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[22]);
        this.creatinine = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[23]);
        this.eGFR = csvRow[24];
        this.pchnLevel = csvRow[25];
        this.tsh = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[26]);
        this.alat = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[27]);
        this.aspat = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[28]);
        this.bilirubin = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[29]);
        this.steroids = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[31]);
        this.alcoholDrinking = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[32]);
        this.pastHemorrhage = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[33]);
        this.crp = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[34]);
        this.thrombocytes = ParsingUtil.parseIntegerListIgnoringEmptyString(csvRow[35]);
        this.hemoglobin = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[36]);
        this.sodium = ParsingUtil.parseIntegerListIgnoringEmptyString(csvRow[37]);
        this.potassium = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[38]);
        this.ntProBNP = ParsingUtil.parseIntegerListIgnoringEmptyString(csvRow[39]);
        this.cholesterol = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[40]);
        this.ldl = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[41]);
        this.hdl = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[42]);
        this.triglicerides = ParsingUtil.parseIntegerListIgnoringEmptyString(csvRow[43]);
        this.lvedd = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[44]);
        this.rvedd = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[45]);
        this.lad = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[46]);
        this.ladCC = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[47]);
        this.lvef = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[48]);
        this.ivsd = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[49]);
        this.lvpwd = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[50]);
        this.lvmi = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[51]);
        this.e = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[52]);
        this.a = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[53]);
        this.decT = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[54]);
        this.eaRatio = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[55]);
        this.eemRatio = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[56]);
        this.disfunctionLevel = csvRow[57];
        this.tapse = ParsingUtil.parseIntegerIgnoringEmptyString(csvRow[58]);
        this.mapse = ParsingUtil.parseIntegerIgnoringEmptyString(csvRow[59]);
        this.asa = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[60]);
        this.clopidogrel = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[61]);
        this.ticagrelor = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[62]);
        this.vka = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[63]);
        this.noac = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[64]);
        this.noacReduced = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[65]);
        this.hdcz = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[66]);
        this.noTreatment = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[67]);
        this.statins = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[68]);
        this.aceinhAT1 = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[69]);
        this.bBlocker = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[70]);
        this.diuretics = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[71]);
        this.mcraSpironol = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[72]);
        this.caBlocker = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[73]);
        this.alphaBlocker = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[74]);
        this.antibiotics = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[75]);
        this.inhaledPOCHP = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[76]);
        this.antiarhythmic = ParsingUtil.parseBooleanIgnoringEmptyString(csvRow[77]);
    }

    public String getId() {
        return id;
    }

    public Boolean getFemale() {
        return female;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getParoxysmalAtrialFibrillation() {
        return paroxysmalAtrialFibrillation;
    }

    public Boolean getPersistentAtrialFibrillation() {
        return persistentAtrialFibrillation;
    }

    public Boolean getChronicAtrialFibrillation() {
        return chronicAtrialFibrillation;
    }

    public Boolean getOver75() {
        return over75;
    }

    public Boolean getBetween65and74() {
        return between65and74;
    }

    public Boolean getArterialHypertension() {
        return arterialHypertension;
    }

    public Boolean getDiabetesType2Insulin() {
        return diabetesType2Insulin;
    }

    public Boolean getDiabetesType2OralMedication() {
        return diabetesType2OralMedication;
    }

    public Boolean getDiabetesType2Diet() {
        return diabetesType2Diet;
    }

    public Boolean getPnspEF() {
        return pnspEF;
    }

    public Boolean getPnsrEF() {
        return pnsrEF;
    }

    public Boolean getPsnmEF() {
        return psnmEF;
    }

    public Boolean getPastHeartAttacks() {
        return pastHeartAttacks;
    }

    public Boolean getPastStrokesOrTIA() {
        return pastStrokesOrTIA;
    }

    public Integer getWeight() {
        return weight;
    }

    public Boolean getNicotineSmoking() {
        return nicotineSmoking;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public Boolean getHeartAttackDuringHospitalization() {
        return heartAttackDuringHospitalization;
    }

    public Boolean getActiveInfectionDuringHospitalization() {
        return activeInfectionDuringHospitalization;
    }

    public List<Double> getCreatinine() {
        return creatinine;
    }

    public String geteGFR() {
        return eGFR;
    }

    public String getPchnLevel() {
        return pchnLevel;
    }

    public List<Double> getTsh() {
        return tsh;
    }

    public List<Double> getAlat() {
        return alat;
    }

    public List<Double> getAspat() {
        return aspat;
    }

    public List<Double> getBilirubin() {
        return bilirubin;
    }

    public Boolean getSteroids() {
        return steroids;
    }

    public Boolean getAlcoholDrinking() {
        return alcoholDrinking;
    }

    public Boolean getPastHemorrhage() {
        return pastHemorrhage;
    }

    public List<Double> getCrp() {
        return crp;
    }

    public List<Integer> getThrombocytes() {
        return thrombocytes;
    }

    public List<Double> getHemoglobin() {
        return hemoglobin;
    }

    public List<Integer> getSodium() {
        return sodium;
    }

    public List<Double> getPotassium() {
        return potassium;
    }

    public List<Integer> getNtProBNP() {
        return ntProBNP;
    }

    public List<Double> getCholesterol() {
        return cholesterol;
    }

    public List<Double> getLdl() {
        return ldl;
    }

    public List<Double> getHdl() {
        return hdl;
    }

    public List<Integer> getTriglicerides() {
        return triglicerides;
    }

    public Double getLvedd() {
        return lvedd;
    }

    public Double getRvedd() {
        return rvedd;
    }

    public Double getLad() {
        return lad;
    }

    public Double getLadCC() {
        return ladCC;
    }

    public Double getLvef() {
        return lvef;
    }

    public Double getIvsd() {
        return ivsd;
    }

    public Double getLvpwd() {
        return lvpwd;
    }

    public Double getLvmi() {
        return lvmi;
    }

    public Double getE() {
        return e;
    }

    public Double getA() {
        return a;
    }

    public Double getDecT() {
        return decT;
    }

    public Double getEaRatio() {
        return eaRatio;
    }

    public Double getEemRatio() {
        return eemRatio;
    }

    public String getDisfunctionLevel() {
        return disfunctionLevel;
    }

    public Integer getTapse() {
        return tapse;
    }

    public Integer getMapse() {
        return mapse;
    }

    public Boolean getAsa() {
        return asa;
    }

    public Boolean getClopidogrel() {
        return clopidogrel;
    }

    public Boolean getTicagrelor() {
        return ticagrelor;
    }

    public Boolean getVka() {
        return vka;
    }

    public Boolean getNoac() {
        return noac;
    }

    public Boolean getNoacReduced() {
        return noacReduced;
    }

    public Boolean getHdcz() {
        return hdcz;
    }

    public Boolean getNoTreatment() {
        return noTreatment;
    }

    public Boolean getStatins() {
        return statins;
    }

    public Boolean getAceinhAT1() {
        return aceinhAT1;
    }

    public Boolean getBBlocker() {
        return bBlocker;
    }

    public Boolean getDiuretics() {
        return diuretics;
    }

    public Boolean getMcraSpironol() {
        return mcraSpironol;
    }

    public Boolean getCaBlocker() {
        return caBlocker;
    }

    public Boolean getAlphaBlocker() {
        return alphaBlocker;
    }

    public Boolean getAntibiotics() {
        return antibiotics;
    }

    public Boolean getInhaledPOCHP() {
        return inhaledPOCHP;
    }

    public Boolean getAntiarhythmic() {
        return antiarhythmic;
    }
}
