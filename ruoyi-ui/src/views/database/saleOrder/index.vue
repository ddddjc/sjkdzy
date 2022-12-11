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
      <el-form-item label="数量" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单时间" prop="purchaseOrderTime">
        <el-date-picker clearable
          v-model="queryParams.purchaseOrderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择订单时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="顾客id" prop="customerId">
        <el-input
          v-model="queryParams.customerId"
          placeholder="请输入顾客id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出售订单号" prop="saleOrderNumber">
        <el-input
          v-model="queryParams.saleOrderNumber"
          placeholder="请输入出售订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注描述" prop="saleOrderDescription">
        <el-input
          v-model="queryParams.saleOrderDescription"
          placeholder="请输入备注描述"
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
          v-hasPermi="['database:saleOrder:add']"
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
          v-hasPermi="['database:saleOrder:edit']"
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
          v-hasPermi="['database:saleOrder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['database:saleOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="saleOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="出售订单id" align="center" prop="saleOrderId" />
      <el-table-column label="产品id" align="center" prop="productId" />
      <el-table-column label="仓库id" align="center" prop="depotId" />
      <el-table-column label="数量" align="center" prop="num" />
      <el-table-column label="订单时间" align="center" prop="purchaseOrderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.purchaseOrderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="顾客id" align="center" prop="customerId" />
      <el-table-column label="出售订单号" align="center" prop="saleOrderNumber" />
      <el-table-column label="备注描述" align="center" prop="saleOrderDescription" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['database:saleOrder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['database:saleOrder:remove']"
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

    <!-- 添加或修改出售订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产品id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入产品id" />
        </el-form-item>
        <el-form-item label="仓库id" prop="depotId">
          <el-input v-model="form.depotId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="订单时间" prop="purchaseOrderTime">
          <el-date-picker clearable
            v-model="form.purchaseOrderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择订单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="顾客id" prop="customerId">
          <el-input v-model="form.customerId" placeholder="请输入顾客id" />
        </el-form-item>
        <el-form-item label="出售订单号" prop="saleOrderNumber">
          <el-input v-model="form.saleOrderNumber" placeholder="请输入出售订单号" />
        </el-form-item>
        <el-form-item label="备注描述" prop="saleOrderDescription">
          <el-input v-model="form.saleOrderDescription" placeholder="请输入备注描述" />
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
import { listSaleOrder, getSaleOrder, delSaleOrder, addSaleOrder, updateSaleOrder } from "@/api/database/saleOrder";

export default {
  name: "SaleOrder",
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
      // 出售订单表格数据
      saleOrderList: [],
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
        purchaseOrderTime: null,
        customerId: null,
        saleOrderNumber: null,
        saleOrderDescription: null
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
    /** 查询出售订单列表 */
    getList() {
      this.loading = true;
      listSaleOrder(this.queryParams).then(response => {
        this.saleOrderList = response.rows;
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
        saleOrderId: null,
        productId: null,
        depotId: null,
        num: null,
        purchaseOrderTime: null,
        customerId: null,
        saleOrderNumber: null,
        saleOrderDescription: null
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
      this.ids = selection.map(item => item.saleOrderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出售订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const saleOrderId = row.saleOrderId || this.ids
      getSaleOrder(saleOrderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出售订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.saleOrderId != null) {
            updateSaleOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSaleOrder(this.form).then(response => {
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
      const saleOrderIds = row.saleOrderId || this.ids;
      this.$modal.confirm('是否确认删除出售订单编号为"' + saleOrderIds + '"的数据项？').then(function() {
        return delSaleOrder(saleOrderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('database/saleOrder/export', {
        ...this.queryParams
      }, `saleOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
