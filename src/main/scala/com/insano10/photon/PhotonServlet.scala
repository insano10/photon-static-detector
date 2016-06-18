package com.insano10.photon

import org.joda.time.format.{DateTimeFormatter, DateTimeFormat}
import org.joda.time.{DateTimeZone, DateTime}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.{Created, Ok, ActionResult}
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.{LoggerFactory, Logger}

class PhotonServlet extends PhotonStaticDetectorStack with JacksonJsonSupport {

  val logger: Logger = LoggerFactory.getLogger(this.getClass)

  protected implicit val jsonFormats: Formats = DefaultFormats

  private val dateTimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yy HH:mm")

  get("/photon/time") {

    logger.info("Getting the time")
    Response(dateTimeFormatter.print(new DateTime()))
  }

  post("/photon/measurements") {

    val measurement = parsedBody.extract[Measurement]
    logger.info("Creating " + measurement.toString)

    Created()
  }

  put("/photon/measurements") {

    val measurement = parsedBody.extract[Measurement]
    logger.info("Updating " + measurement.toString)

    Ok()
  }

  delete("/photon/measurements/:id") {

    logger.info("Deleting " + params("id"))

    Ok()
  }

}

case class Measurement(val measurementType: String, val value: Integer)

case class Response(val message: String)
