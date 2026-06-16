package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dtos.MemoDTO;
import com.example.demo.Domain.Common.Dtos.PageDTO;
import com.example.demo.Domain.Common.Entity.Memo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemoService {
    // 메모등록
    boolean memoRegistration(MemoDTO memoDTO) throws Exception;
    // 메모리스트
    public Map<String, Object> getMemoList(PageDTO pageDTO) throws Exception;
    // 메모업데이트
    public MemoDTO getMemo(Long id) throws Exception;
    public boolean updatePostMemo(MemoDTO dto);
    // 메모삭제
    public void deleteMemo(Long id) throws Exception;

    boolean removeMemo(Long id) throws Exception;
}
