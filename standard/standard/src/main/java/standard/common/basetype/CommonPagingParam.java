package standard.common.basetype;

import java.io.Serializable;
import lombok.Data;


@Data
public class CommonPagingParam implements Serializable {

  private static final long serialVersionUID = 7663723321132318683L;

  protected int pageNo;

  protected int countPerPage = 10;

  public CommonPagingParam(int pageNo, int countPerPage) {
    this.pageNo = pageNo;
    this.countPerPage = countPerPage;
  }

  public CommonPagingParam(String pageNoStr, int countPerPage) {
    this(pageNoToInt(pageNoStr), countPerPage);
  }

  private static int pageNoToInt(String pageNoStr) {
    int pageNo = -1;

    if (pageNoStr!=null) {
      pageNo = Integer.parseInt(pageNoStr);
    } else {
      pageNo = 1;
    }

    return pageNo;
  }

  public int getOffset() {
    return (this.pageNo - 1) * countPerPage;
  }
}
