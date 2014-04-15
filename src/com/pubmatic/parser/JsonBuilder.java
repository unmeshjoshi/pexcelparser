package com.pubmatic.parser;

import com.google.gson.Gson;

public class JsonBuilder {
    public String toJson(Onboarding desktopApplications) {
        return new Gson().toJson(desktopApplications);
    }
}
