package com.example.carsinfos.domain.model

data class CarModelEngine(
    val cam_type: String? = null,
    val cylinders: String? = null,
    val engine_type: String? = null,
    val fuel_type: String? = null,
    val horsepower_hp: Int? = null,
    val horsepower_rpm: Int? = null,
    val id: Int? = null,
    val make: String? = null,
    val make_id: Int? = null,
    val model: String? = null,
    val model_id: Int? = null,
    val series: Any? = null,
    val size: String? = null,
    val submodel: String? = null,
    val submodel_id: Int? = null,
    val torque_ft_lbs: Int? = null,
    val torque_rpm: Int? = null,
    val trim: String? = null,
    val trim_description: String? = null,
    val trim_id: Int? = null,
    val valve_timing: String? = null,
    val valves: Int? = null,
    val year: Int? = null
)
