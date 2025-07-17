### LEVEL 2 - SQL LIKE 연산
#### 1. LIKE 연산 시 와일드 카드를 사용한 키워드 조회
    - JQPL 
        select m from Memo m where m.contents like concat('%', :keyword, '%') order by m.updatedAt desc

    - Query Method
        List<Memo> findMemosByContentsContainsOrderByUpdatedAtDesc(String keyword);

