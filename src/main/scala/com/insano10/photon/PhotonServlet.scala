package com.insano10.photon

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.{LoggerFactory, Logger}

class PhotonServlet extends PhotonStaticDetectorStack with JacksonJsonSupport {

  val logger: Logger = LoggerFactory.getLogger(this.getClass)

  protected implicit val jsonFormats: Formats = DefaultFormats

  post("/photon/measurements") {

    val measurement = parsedBody.extract[Measurement]
    logger.info(measurement.toString)

    Response("Success")
  }

}

case class Measurement(val measurementType: String, val value: Integer)
case class Response(val message: String)
