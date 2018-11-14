package aiwd.model;

import aiwd.util.ParsingUtil;

import java.util.List;

public class DataRow {

    private String id;
    private Double female;
    private Double age;
    private Double paroxysmalAtrialFibrillation;    //(napadowe migotanie przedsionków)
    private Double persistentAtrialFibrillation;    //(przetrwale)
    private Double chronicAtrialFibrillation;   //(utrwalone)
    private Double over75;
    private Double between65and74;
    private Double arterialHypertension;
    private Double diabetesType2Insulin;
    private Double diabetesType2OralMedication;
    private Double diabetesType2Diet;
    private Double pnspEF;
    private Double pnsrEF;
    private Double psnmEF;
    private Double pastHeartAttacks;
    private Double pastStrokesOrTIA;
    private Double weight;
    private Double nicotineSmoking;
    private Double heartRate1;
    private Double heartRate2;
    private Double heartAttackDuringHospitalization;
    private Double activeInfectionDuringHospitalization;
    private List<Double> creatinine;
    private String eGFR;
    private String pchnLevel;
    private List<Double> tsh;
    private List<Double> alat;
    private List<Double> aspat;
    private List<Double> bilirubin;
    private Double steroids;
    private Double alcoholDrinking;
    private Double pastHemorrhage;
    private List<Double> crp;
    private List<Double> thrombocytes;
    private List<Double> hemoglobin;
    private List<Double> sodium;
    private List<Double> potassium;
    private List<Double> ntProBNP;
    private List<Double> cholesterol;
    private List<Double> ldl;
    private List<Double> hdl;
    private List<Double> triglicerides;
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
    private Double tapse;
    private Double mapse;
    private Double asa;
    private Double clopidogrel;
    private Double ticagrelor;
    private Double vka;
    private Double noac;
    private Double noacReduced;
    private Double hdcz;
    private Double noTreatment;
    private Double statins;
    private Double aceinhAT1;
    private Double bBlocker;
    private Double diuretics;  //leki moczopedne
    private Double mcraSpironol;
    private Double caBlocker;
    private Double alphaBlocker;
    private Double antibiotics;
    private Double inhaledPOCHP;
    private Double antiarhythmic;

    public DataRow(String[] csvRow) {
        this.id = csvRow[0];
        this.female = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[2]);
        this.age = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[3]);
        this.paroxysmalAtrialFibrillation = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[4]);
        this.persistentAtrialFibrillation = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[5]);
        this.chronicAtrialFibrillation = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[6]);
        this.over75 = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[7]);
        this.between65and74 = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[8]);
        this.arterialHypertension = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[9]);
        this.diabetesType2Insulin = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[10]);
        this.diabetesType2OralMedication = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[11]);
        this.diabetesType2Diet = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[12]);
        this.pnspEF = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[13]);
        this.pnsrEF = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[14]);
        this.psnmEF = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[15]);
        this.pastHeartAttacks = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[16]);
        this.pastStrokesOrTIA = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[17]);
        this.weight = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[18]);
        this.nicotineSmoking = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[19]);
        String[] splittedHeartRate = csvRow[20].split("/");
        if(splittedHeartRate.length==2) {
            this.heartRate1 = ParsingUtil.parseDoubleIgnoringEmptyString(splittedHeartRate[0]);
            this.heartRate2 = ParsingUtil.parseDoubleIgnoringEmptyString(splittedHeartRate[1]);
        }
        this.heartAttackDuringHospitalization = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[21]);
        this.activeInfectionDuringHospitalization = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[22]);
        this.creatinine = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[23]);
        this.eGFR = csvRow[24];
        this.pchnLevel = csvRow[25];
        this.tsh = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[26]);
        this.alat = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[27]);
        this.aspat = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[28]);
        this.bilirubin = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[29]);
        this.steroids = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[31]);
        this.alcoholDrinking = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[32]);
        this.pastHemorrhage = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[33]);
        this.crp = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[34]);
        this.thrombocytes = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[35]);
        this.hemoglobin = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[36]);
        this.sodium = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[37]);
        this.potassium = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[38]);
        this.ntProBNP = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[39]);
        this.cholesterol = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[40]);
        this.ldl = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[41]);
        this.hdl = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[42]);
        this.triglicerides = ParsingUtil.parseDoubleListIgnoringEmptyString(csvRow[43]);
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
        this.tapse = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[58]);
        this.mapse = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[59]);
        this.asa = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[60]);
        this.clopidogrel = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[61]);
        this.ticagrelor = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[62]);
        this.vka = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[63]);
        this.noac = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[64]);
        this.noacReduced = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[65]);
        this.hdcz = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[66]);
        this.noTreatment = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[67]);
        this.statins = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[68]);
        this.aceinhAT1 = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[69]);
        this.bBlocker = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[70]);
        this.diuretics = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[71]);
        this.mcraSpironol = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[72]);
        this.caBlocker = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[73]);
        this.alphaBlocker = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[74]);
        this.antibiotics = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[75]);
        this.inhaledPOCHP = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[76]);
        this.antiarhythmic = ParsingUtil.parseDoubleIgnoringEmptyString(csvRow[77]);
    }

    public String getId() {
        return id;
    }

    public Double getFemale() {
        return female;
    }

    public Double getAge() {
        return age;
    }

    public Double getParoxysmalAtrialFibrillation() {
        return paroxysmalAtrialFibrillation;
    }

    public Double getPersistentAtrialFibrillation() {
        return persistentAtrialFibrillation;
    }

    public Double getChronicAtrialFibrillation() {
        return chronicAtrialFibrillation;
    }

    public Double getOver75() {
        return over75;
    }

    public Double getBetween65and74() {
        return between65and74;
    }

    public Double getArterialHypertension() {
        return arterialHypertension;
    }

    public Double getDiabetesType2Insulin() {
        return diabetesType2Insulin;
    }

    public Double getDiabetesType2OralMedication() {
        return diabetesType2OralMedication;
    }

    public Double getDiabetesType2Diet() {
        return diabetesType2Diet;
    }

    public Double getPnspEF() {
        return pnspEF;
    }

    public Double getPnsrEF() {
        return pnsrEF;
    }

    public Double getPsnmEF() {
        return psnmEF;
    }

    public Double getPastHeartAttacks() {
        return pastHeartAttacks;
    }

    public Double getPastStrokesOrTIA() {
        return pastStrokesOrTIA;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getNicotineSmoking() {
        return nicotineSmoking;
    }

    public Double getHeartRate1() {
        return heartRate1;
    }

    public Double getHeartRate2() {
        return heartRate2;
    }

    public Double getHeartAttackDuringHospitalization() {
        return heartAttackDuringHospitalization;
    }

    public Double getActiveInfectionDuringHospitalization() {
        return activeInfectionDuringHospitalization;
    }

    public List<Double> getCreatinine() {
        return creatinine;
    }

    public String getEGFR() {
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

    public Double getSteroids() {
        return steroids;
    }

    public Double getAlcoholDrinking() {
        return alcoholDrinking;
    }

    public Double getPastHemorrhage() {
        return pastHemorrhage;
    }

    public List<Double> getCrp() {
        return crp;
    }

    public List<Double> getThrombocytes() {
        return thrombocytes;
    }

    public List<Double> getHemoglobin() {
        return hemoglobin;
    }

    public List<Double> getSodium() {
        return sodium;
    }

    public List<Double> getPotassium() {
        return potassium;
    }

    public List<Double> getNtProBNP() {
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

    public List<Double> getTriglicerides() {
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

    public Double getTapse() {
        return tapse;
    }

    public Double getMapse() {
        return mapse;
    }

    public Double getAsa() {
        return asa;
    }

    public Double getClopidogrel() {
        return clopidogrel;
    }

    public Double getTicagrelor() {
        return ticagrelor;
    }

    public Double getVka() {
        return vka;
    }

    public Double getNoac() {
        return noac;
    }

    public Double getNoacReduced() {
        return noacReduced;
    }

    public Double getHdcz() {
        return hdcz;
    }

    public Double getNoTreatment() {
        return noTreatment;
    }

    public Double getStatins() {
        return statins;
    }

    public Double getAceinhAT1() {
        return aceinhAT1;
    }

    public Double getBBlocker() {
        return bBlocker;
    }

    public Double getDiuretics() {
        return diuretics;
    }

    public Double getMcraSpironol() {
        return mcraSpironol;
    }

    public Double getCaBlocker() {
        return caBlocker;
    }

    public Double getAlphaBlocker() {
        return alphaBlocker;
    }

    public Double getAntibiotics() {
        return antibiotics;
    }

    public Double getInhaledPOCHP() {
        return inhaledPOCHP;
    }

    public Double getAntiarhythmic() {
        return antiarhythmic;
    }
}
