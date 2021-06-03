package uk.gov.hmcts.reform.docgen.scenarios.bundling

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Document {

  val extToContentType = Map(
    "pdf" -> "application/pdf",
    "docx" -> "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    "txt" -> "text/plain",
    "mp3" -> "audio/mpeg",
  )

  var uploadedDocuments = new ListBuffer[String]()

  val uploadedDocumentsFeeder = Iterator.continually(Map("document_id" -> uploadedDocuments(Random.nextInt(uploadedDocuments.length))))


  val largeDocuments = List(
    "460mbaudio.mp3"
  )

  val largeDocumentsFeeder = Iterator.continually(Map("document_file" -> largeDocuments(Random.nextInt(largeDocuments.length))))


  def contentType(fileName: String): String = {
    extToContentType(fileName.substring(fileName.length - 3))
  }

}
