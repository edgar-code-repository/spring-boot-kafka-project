package com.example.upload.kafka.consumer.mapper;

import com.example.upload.kafka.consumer.to.FileUpload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileUploadMapper {

    @Select("SELECT * FROM tbl_file_upload WHERE file_upload_id = #{fileUploadId}")
    FileUpload getFileUploaded(Integer fileUploadId);

}
