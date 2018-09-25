package org.ccfebras.ckp.model.ckp;

public enum  CkpStatusName {
    STATUS_CREATION_REQUESTED, // Запрошено создание нового ЦКП
    STATUS_CREATION_APPROVED,  // Подтверждено создание нового ЦКП
    STATUS_CREATION_DECLINED,  // Запрещено создание нового ЦКП
    STATUS_CREATION_ON_WORK,   // Создание нового ЦКП взято в работу
    STATUS_RUNTIME_BLOCKED,    // ЦКП заблокирован во время работы
    STATUS_DELETED             // ЦКП удалён
}
