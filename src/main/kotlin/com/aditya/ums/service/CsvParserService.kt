package com.aditya.ums.service

import com.aditya.ums.api.request.CsvUserRequest
import com.aditya.ums.exception.BadRequestException
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.io.InputStreamReader

class CsvParserService {
    companion object{
        fun parseUserCsvToEntity(file: MultipartFile): MutableSet<CsvUserRequest> {
            try{
                val csvParser = CSVParser(
                    InputStreamReader(file.inputStream),
                    CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim()
                )
                val csvUserRequest : MutableSet<CsvUserRequest> = mutableSetOf()
                for (csvRecord in csvParser) {
                    // Accessing values by the names assigned to each column
                    csvUserRequest.add(
                        CsvUserRequest(
                            username = csvRecord[0],
                            email = csvRecord["email"],
                            firstname = csvRecord["firstname"],
                            lastname = csvRecord["lastname"],
                            gender = csvRecord["gender"].toUpperCase(),
                            dob = csvRecord["DOB"],
                            phone = csvRecord["phone"],
                            country = csvRecord["country"],
                            aadhar = csvRecord["aadhar"].toLong()
                        )
                    )
                }
                csvParser.close()
                return csvUserRequest
            } catch (ex: IOException){
                throw BadRequestException("Error in file", ex)
            }
        }
        //todo excel
//        fun parseUserExcelToEntity(file:MultipartFile): MutableSet<CsvUserRequest>{
//
//        }
    }
}