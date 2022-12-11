<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="产品id" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入产品id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库id" prop="depotId">
        <el-input
          v-model="queryParams.depotId"
          placeholder="请输入仓库id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采购数量" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入采购数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采购商id" prop="providerId">
        <el-input
          v-model="queryParams.providerId"
          placeholder="请输入采购商id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采购时间" prop="purchaseOrderTime">
        <el-date-picker clearable
          v-model="queryParams.purchaseOrderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择采购时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="采购订单号" prop="purchaseOrderNumber">
        <el-input
          v-model="queryParams.purchaseOrderNumber"
          placeholder="请输入采购订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采购单描述" prop="purchaseOrderDescription">
        <el-input
          v-model="queryParams.purchaseOrderDescription"
          placeholder="请输入采购单描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['database:purchaseOrder:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['database:purchaseOrder:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['database:purchaseOrder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['database:purchaseOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="purchaseOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="采购订单id" align="center" prop="purchaseOrderId" />
      <el-table-column label="产品id" align="center" prop="productId" />
      <el-table-column label="仓库id" align="center" prop="depotId" />
      <el-table-column label="采购数量" align="center" prop="num" />
      <el-table-column label="采购商id" align="center" prop="providerId" />
      <el-table-column label="采购时间" align="center" prop="purchaseOrderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.purchaseOrderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="采购订单号" align="center" prop="purchaseOrderNumber" />
      <el-table-column label="采购单描述" align="center" prop="purchaseOrderDescription" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['database:purchaseOrder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['database:purchaseOrder:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改采购订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产品id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入产品id" />
        </el-form-item>
        <el-form-item label="仓库id" prop="depotId">
          <el-input v-model="form.depotId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="采购数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入采购数量" />
        </el-form-item>
        <el-form-item label="采购商id" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入采购商id" />
        </el-form-item>
        <el-form-item label="采购时间" prop="purchaseOrderTime">
          <el-date-picker clearable
            v-model="form.purchaseOrderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择采购时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="采购订单号" prop="purchaseOrderNumber">
          <el-input v-model="form.purchaseOrderNumber" placeholder="请输入采购订单号" />
        </el-form-item>
        <el-form-item label="采购单描述" prop="purchaseOrderDescription">
          <el-input v-model="form.purchaseOrderDescription" placeholder="请输入采购单描述" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPurchaseOrder, getPurchaseOrder, delPurchaseOrder, addPurchaseOrder, updatePurchaseOrder } from "@/api/database/purchaseOrder";

export default {
  name: "PurchaseOrder",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 采购订单表格数据
      purchaseOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productId: null,
        depotId: null,
        num: null,
        providerId: null,
        purchaseOrderTime: null,
        purchaseOrderNumber: null,
        purchaseOrderDescription: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询采购订单列表 */
    getList() {
      this.loading = true;
      listPurchaseOrder(this.queryParams).then(response => {
        this.purchaseOrderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        purchaseOrderId: null,
        productId: null,
        depotId: null,
        num: null,
        providerId: null,
        purchaseOrderTime: null,
        purchaseOrderNumber: null,
        purchaseOrderDescription: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.purchaseOrderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加采购订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const purchaseOrderId = row.purchaseOrderId || this.ids
      getPurchaseOrder(purchaseOrderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.purchaseOrderId != null) {
            updatePurchaseOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPurchaseOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const purchaseOrderIds = row.purchaseOrderId || this.ids;
      this.$modal.confirm('是否确认删除采购订单编号为"' + purchaseOrderIds + '"的数据项？').then(function() {
        return delPurchaseOrder(purchaseOrderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('database/purchaseOrder/export', {
        ...this.queryParams
      }, `purchaseOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
