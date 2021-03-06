/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.giraph.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.JobID;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

/*if_not[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/
import org.apache.hadoop.mapreduce.task.JobContextImpl;
import org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl;
/*end[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/

/**
 * Helpers for dealing with Hadoop.
 */
public class HadoopUtils {
  /** Don't construct */
  private HadoopUtils() { }

  /**
   * Create a TaskAttemptContext, supporting many Hadoops.
   *
   * @param conf Configuration
   * @return TaskAttemptContext
   */
  public static TaskAttemptContext makeTaskAttemptContext(Configuration conf) {
    TaskAttemptContext context;
    /*if[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]
    context = new TaskAttemptContext(conf, new TaskAttemptID());
    else[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/
    context = new TaskAttemptContextImpl(conf, new TaskAttemptID());
    /*end[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/
    return context;
  }

  /**
   * Create a TaskAttemptContext, supporting many Hadoops.
   *
   * @return TaskAttemptContext
   */
  public static TaskAttemptContext makeTaskContext() {
    return makeTaskAttemptContext(new Configuration());
  }

  /**
   * Create a JobContext, supporting many Hadoops.
   *
   * @param conf Configuration
   * @return JobContext
   */
  public static JobContext makeJobContext(Configuration conf) {
    JobContext context;
    /*if[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]
    context = new JobContext(conf, new JobID());
    else[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/
    context = new JobContextImpl(conf, new JobID());
    /*end[HADOOP_NON_JOBCONTEXT_IS_INTERFACE]*/
    return context;
  }

  /**
   * Create a JobContext, supporting many Hadoops.
   *
   * @return JobContext
   */
  public static JobContext makeJobContext() {
    return makeJobContext(new Configuration());
  }
}
