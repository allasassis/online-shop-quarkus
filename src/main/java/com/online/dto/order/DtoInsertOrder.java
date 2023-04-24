package com.online.dto.order;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public record DtoInsertOrder(@Email String email, @NotNull @Valid List<DtoOrderItem> itemList) {
}
