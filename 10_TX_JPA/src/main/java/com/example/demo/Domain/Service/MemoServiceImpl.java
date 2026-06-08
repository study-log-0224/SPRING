package com.example.demo.Domain.Service;

import com.example.demo.Domain.Common.Dtos.MemoDTO;
import com.example.demo.Domain.Common.Dtos.PageBlock;
import com.example.demo.Domain.Common.Dtos.PageDTO;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {
    @Autowired
    private MemoRepository memoRepository;

    // 메모등록
    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public boolean memoRegistration(MemoDTO memoDTO) throws Exception {
        memoDTO.setCreateAt(LocalDateTime.now());
        memoRepository.save(memoDTO.toEtity());
        return true;
    }
    // 페이징처리
    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public Map<String, Object> getMemoList(PageDTO pageDTO) throws Exception {
        Map<String, Object> returnValue = new HashMap<>();

        //서비스(+페이징처리)
        int pageNo = 0;     //현재 pageNo
        int amount = 10;    //한페이지 표시할 게시물 건수
        if(pageDTO.getPageNo()!=null)
            pageNo = pageDTO.getPageNo();
        else
            pageDTO.setPageNo(0);

        if(pageDTO.getAmount()!=null)
            amount = pageDTO.getAmount();
        else
            pageDTO.setAmount(10);

        Pageable pageable = PageRequest.of(pageNo,amount, Sort.by("id").descending());
        Page<Memo> page =  memoRepository.findAll(pageable);
        PageBlock pageBlock = new PageBlock(pageDTO,page);
        List<Memo> list = page.getContent();
        returnValue.put("page",page);
        returnValue.put("pageBlock",pageBlock);
        returnValue.put("list",list);

        return returnValue;
    }
    // update
    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public MemoDTO getMemo(Long id) throws Exception {
        Optional<Memo> memoOp = memoRepository.findById(id);
        if(memoOp.isPresent()) {
            return MemoDTO.from(memoOp.get());
        }
        return null;
    }
    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public boolean updatePostMemo(MemoDTO dto) {

//        Memo memo = Memo.builder()
//                .id(dto.getId())
//                .text(dto.getText())
//                .title(dto.getTitle())
//                .writer(dto.getWriter())
//                .createAt(LocalDateTime.now())
//                .build();
        memoRepository.save(dto.toEtity());
        return dto.getId()>0;
    }


    // delete
    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManger")
    public boolean removeMemo(Long id) throws Exception {
        memoRepository.deleteById(id);
        return true;
    }

    // DTOtoEntity


    // EntitytoDTO
}
