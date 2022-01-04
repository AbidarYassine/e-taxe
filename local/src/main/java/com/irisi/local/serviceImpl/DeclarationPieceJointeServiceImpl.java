package com.irisi.local.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.irisi.local.bean.DeclarationPieceJointe;
import com.irisi.local.dao.DeclarationPieceJointeDao;
import com.irisi.local.service.DeclarationPieceJointeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class DeclarationPieceJointeServiceImpl implements DeclarationPieceJointeService {


    private final DeclarationPieceJointeDao declarationPieceJointeDao;
    private final Cloudinary cloudinary;

    public DeclarationPieceJointeServiceImpl(DeclarationPieceJointeDao declarationPieceJointeDao, Cloudinary cloudinary) {
        this.declarationPieceJointeDao = declarationPieceJointeDao;
        this.cloudinary = cloudinary;
    }

    @Override
    public DeclarationPieceJointe save(DeclarationPieceJointe declarationPieceJointe, MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),  ObjectUtils.asMap("resource_type", "auto"));
            String url = uploadResult.get("url").toString();
            declarationPieceJointe.setUrl(url);
            return declarationPieceJointeDao.save(declarationPieceJointe);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return  null;
    }

    @Override
    public List<DeclarationPieceJointe> findAll() {
        return declarationPieceJointeDao.findAll();
    }
}
