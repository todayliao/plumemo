package com.byteblogs.helloblog.file.controller;

import com.byteblogs.common.base.domain.Result;
import com.byteblogs.helloblog.file.factory.UploadFileFactory;
import com.byteblogs.helloblog.file.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: zsg
 * @description:
 * @date: 2019/1/13 10:51
 * @modified:
 */
@RestController
@RequestMapping("/file")
public class UploadFileController {

    @PostMapping("/file/v1/upload")
    public Result uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        String store = UploadFileFactory.getUploadFileService().saveFileStore(file);
        return Result.createWithSuccessMessage().setExtra(store);
    }

}
