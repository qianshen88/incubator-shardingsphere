/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.api.config.encryptor;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.Getter;
import org.apache.shardingsphere.api.config.TypeBasedSPIConfiguration;

import java.util.Properties;

/**
 * Encryptor configuration.
 *
 * @author panjuan
 */
@Getter
public final class EncryptorRuleConfiguration extends TypeBasedSPIConfiguration {
    
    private final String qualifiedColumns;
    
    private String assistedQueryColumns;
    
    public EncryptorRuleConfiguration(final String type, final String qualifiedColumns, final Properties properties) {
        this(type, qualifiedColumns, "", properties);
    }
    
    public EncryptorRuleConfiguration(final String type, final String qualifiedColumns, final String assistedQueryColumns, final Properties properties) {
        super(type, properties);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(qualifiedColumns), "qualifiedColumns is required.");
        this.qualifiedColumns = qualifiedColumns;
        this.assistedQueryColumns = null == assistedQueryColumns ? "" : assistedQueryColumns;
    }
}
