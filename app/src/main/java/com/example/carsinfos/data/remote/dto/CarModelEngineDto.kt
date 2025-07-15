package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.CarModelEngine

data class CarModelEngineDto(
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
    val year: Int? = null,
)

fun CarModelEngineDto.toCarModelEngine(): CarModelEngine {
    return CarModelEngine(
        cam_type = cam_type,
        cylinders = cylinders,
        engine_type = engine_type,
        fuel_type = fuel_type,
        horsepower_hp = horsepower_hp,
        horsepower_rpm = horsepower_rpm,
        id = id,
        make = make,
        make_id = make_id,
        model = model,
        model_id = model_id,
        series = series,
        size = size,
        submodel = submodel,
        submodel_id = submodel_id,
        torque_ft_lbs = torque_ft_lbs,
        torque_rpm = torque_rpm,
        trim = trim,
        trim_description = trim_description,
        trim_id = trim_id,
        valve_timing = valve_timing,
        valves = valves,
        year = year
    )

}