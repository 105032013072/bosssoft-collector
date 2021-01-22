package com.bosssoft.platform.collector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CollectorProperties {

    private  Integer trialTime;

   
    public void loadProperties(){
        InputStream in = null;
        try {
            in = Object.class.getResourceAsStream("/bosssoft.properties");
            Properties p = new Properties();

            p.load(in);
            String trialTimeStr = p.getProperty("trial.time.month", "1").trim();
            trialTime = Integer.parseInt(trialTimeStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }

    public Integer getTrialTime() {
        return trialTime;
    }

    public void setTrialTime(Integer trialTime) {
        this.trialTime = trialTime;
    }

}
