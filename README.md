### LEVEL 2 - SQL LIKE 연산
#### 1. LIKE 연산 시 와일드 카드를 사용한 키워드 조회

- *JPQL*
> ``` select m from Memo m where m.contents like concat('%', :keyword, '%') order by m.updatedAt desc ```
- *Query Method*
> ``` List<Memo> findMemosByContentsContainsOrderByUpdatedAtDesc(String keyword); ```

---

### LEVEL 3 
#### 1. Email 검증
- *@NotNull* : NULL 검사
- *@Pattern* : 정규식 검사
> ``` @NotNull @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$") ```