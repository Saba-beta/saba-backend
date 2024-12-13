package saba.example.common.spi;

public interface FeignClientPort {
    String getCompanyName(String businessNumber);

    boolean getCompanyExist(String businessNumber);
}
