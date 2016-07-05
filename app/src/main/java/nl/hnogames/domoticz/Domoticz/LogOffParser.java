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

package nl.hnogames.domoticz.Domoticz;

import nl.hnogames.domoticz.Interfaces.JSONParserInterface;

public class LogOffParser implements JSONParserInterface {

    private static final String TAG = LogOffParser.class.getSimpleName();

    public LogOffParser() {
        //TODO: extend this parser with status info
    }

    @Override
    public void parseResult(String result) {
    }

    @Override
    public void onError(Exception error) {
    }
}