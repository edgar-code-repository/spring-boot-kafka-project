package com.example.upload.kafka.consumer.mapper;

import com.example.upload.kafka.consumer.to.FileUpload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FileUploadMapper {

    @Select("SELECT * FROM tbl_file_upload WHERE file_upload_id=#{fileUploadId}")
    FileUpload getFileUploaded(Integer fileUploadId);

    @Update("UPDATE tbl_file_upload set state=#{state} where file_upload_id=#{fileUploadId}")
    void update(FileUpload fileUpload);

}
