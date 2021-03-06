/*
 *
 *  Copyright 2020 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Titus job request DTO.
 *
 * @author mprimi
 * @since 4.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public class TitusBatchJobRequest {

    @NotNull private final Owner owner;
    @NotNull private final String applicationName;
    @NotNull private final String capacityGroup;
    @NotNull private final Map<String, String> attributes;
    @NotNull private final Container container;
    @NotNull private final Batch batch;
    @NotNull private final DisruptionBudget disruptionBudget;

    /**
     * Titus job owner DTO.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Owner {
        private final String teamEmail;
    }

    /**
     * Titus job container DTO.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Container {
        private final Resources resources;
        private final SecurityProfile securityProfile;
        private final Image image;
        private final List<String> entryPoint;
        private final Map<String, String> env;
    }

    /**
     * Titus job container resources DTO.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Resources {
        private final int cpu;
        private final int gpu;
        private final long memoryMB;
        private final long diskMB;
        private final long networkMbps;
    }

    /**
     * Titus job security profile.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class SecurityProfile {
        private final Map<String, String> attributes;
        private final List<String> securityGroups;
        private final String iamRole;
    }

    /**
     * Titus job container image.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Image {
        private final String name;
        private final String tag;
    }

    /**
     * Titus batch job parameters.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Batch {
        private final int size;
        private final RetryPolicy retryPolicy;
        private final long runtimeLimitSec;
    }

    /**
     * Titus job disruption budget.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class DisruptionBudget {
        private final SelfManaged selfManaged;
    }

    /**
     * Titus job retry policy.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class RetryPolicy {
        private final Immediate immediate;
    }

    /**
     * Titus job retry policy detail.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Immediate {
        private final int retries;
    }

    /**
     * Titus job disruption budget detail.
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public static class SelfManaged {
        private final long relocationTimeMs;
    }
}

