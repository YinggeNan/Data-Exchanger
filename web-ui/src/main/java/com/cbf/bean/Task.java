package com.cbf.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
@Data
public class Task {
    private int id;
    private String task_name;
    private String reader_type;
    private String reader_json_config;
    private String sinker_type;
    private String sinker_json_config;
    private String intermediateProcessor_className;
    private Integer blocking_queue_size;
    private String column_map_json_config;
    private Integer concurrent_number;
    private boolean is_delete;
    private Timestamp create_time;
    private Timestamp update_time;
}
