/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.tasks.compile.incremental.cache;

import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.cache.CacheRepository;

public class DefaultLocalCompilationCaches implements LocalCompilationCaches {

    private final CacheRepository repository;
    private final JavaCompile javaCompile;

    public DefaultLocalCompilationCaches(CacheRepository repository, JavaCompile javaCompile) {
        this.repository = repository;
        this.javaCompile = javaCompile;
    }

    public LocalJarHashesStore getLocalJarHashesStore() {
        return new LocalJarHashesStore(repository, javaCompile);
    }

    public LocalClassDependencyInfoStore getLocalClassDependencyInfoStore() {
        return new LocalClassDependencyInfoStore(repository, javaCompile);
    }
}