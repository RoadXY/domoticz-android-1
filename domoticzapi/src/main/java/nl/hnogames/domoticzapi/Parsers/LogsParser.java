/*
 * Copyright (C) 2015 Domoticz
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package nl.hnogames.domoticzapi.Parsers;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import nl.hnogames.domoticzapi.Containers.LogInfo;
import nl.hnogames.domoticzapi.Interfaces.JSONParserInterface;
import nl.hnogames.domoticzapi.Interfaces.LogsReceiver;

public class LogsParser implements JSONParserInterface {

    private static final String TAG = LogsParser.class.getSimpleName();
    private LogsReceiver logsReceiver;

    public LogsParser(LogsReceiver logsReceiver) {
        this.logsReceiver = logsReceiver;
    }

    @Override
    public void parseResult(String result) {

        try {
            JSONArray jsonArray = new JSONArray(result);
            ArrayList<LogInfo> mLogs = new ArrayList<>();

            if (jsonArray.length() > 0) {

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject row = jsonArray.getJSONObject(i);

                    mLogs.add(new LogInfo(row));
                }
            }

            logsReceiver.onReceiveLogs(mLogs);

        } catch (JSONException e) {
            Log.e(TAG, "logsParser JSON exception");
            e.printStackTrace();
            logsReceiver.onError(e);
        }
    }

    @Override
    public void onError(Exception error) {
        Log.e(TAG, "logsParser of JSONParserInterface exception");
        logsReceiver.onError(error);
    }

}