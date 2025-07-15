package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.CarModelBody

data class CarModelBodyDto(
    val cargo_capacity: String? = null,
    val curb_weight: Int? = null,
    val doors: Int? = null,
    val front_track: Any? = null,
    val gross_weight: Any? = null,
    val ground_clearance: String? = null,
    val height: String? = null,
    val id: Int? = null,
    val length: String? = null,
    val make: String? = null,
    val make_id: Int? = null,
    val max_cargo_capacity: Any? = null,
    val max_payload: Any? = null,
    val max_towing_capacity: Any? = null,
    val model: String? = null,
    val model_id: Int? = null,
    val rear_track: Any? = null,
    val seats: Int? = null,
    val series: Any? = null,
    val submodel: String? = null,
    val submodel_id: Int? = null,
    val trim: String? = null,
    val trim_description: String? = null,
    val trim_id: Int? = null,
    val type: String? = null,
    val wheel_base: String? = null,
    val width: String? = null,
    val year: Int? = null
)

fun CarModelBodyDto.toCarModelBody() : CarModelBody {
    return CarModelBody(
        cargo_capacity = cargo_capacity,
        curb_weight = curb_weight,
        doors = doors,
        front_track = front_track,
        gross_weight = gross_weight,
        ground_clearance = ground_clearance,
        height = height,
        id = id,
        length = length,
        make = make,
        make_id = make_id,
        max_cargo_capacity = max_cargo_capacity,
        max_payload = max_payload,
        max_towing_capacity = max_towing_capacity,
        model = model,
        model_id = model_id,
        rear_track = rear_track,
        seats = seats,
        series = series,
        submodel = submodel,
        submodel_id = submodel_id,
        trim = trim,
        trim_description = trim_description,
        trim_id = trim_id,
        type = type,
        wheel_base = wheel_base,
        width = width,
        year = year
    )
}