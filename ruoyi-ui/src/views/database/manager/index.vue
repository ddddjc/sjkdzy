<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="仓库管理人电话" prop="depotManagerTelephone">
        <el-input
          v-model="queryParams.depotManagerTelephone"
          placeholder="请输入仓库管理人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库管理员工资" prop="depotSalary">
        <el-input
          v-model="queryParams.depotSalary"
          placeholder="请输入仓库管理员工资"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库管理员年龄" prop="depotAge">
        <el-input
          v-model="queryParams.depotAge"
          placeholder="请输入仓库管理员年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库管理员描述" prop="depotDescription">
        <el-input
          v-model="queryParams.depotDescription"
          placeholder="请输入仓库管理员描述"
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
          v-hasPermi="['database:manager:add']"
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
          v-hasPermi="['database:manager:edit']"
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
          v-hasPermi="['database:manager:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['database:manager:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="仓库管理人id" align="center" prop="depotManagerId" />
      <el-table-column label="仓库管理人电话" align="center" prop="depotManagerTelephone" />
      <el-table-column label="仓库管理员性别" align="center" prop="depotSex" />
      <el-table-column label="仓库管理员工资" align="center" prop="depotSalary" />
      <el-table-column label="仓库管理员年龄" align="center" prop="depotAge" />
      <el-table-column label="仓库管理员描述" align="center" prop="depotDescription" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['database:manager:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['database:manager:remove']"
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

    <!-- 添加或修改仓库管理员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="仓库管理人电话" prop="depotManagerTelephone">
          <el-input v-model="form.depotManagerTelephone" placeholder="请输入仓库管理人电话" />
        </el-form-item>
        <el-form-item label="仓库管理员工资" prop="depotSalary">
          <el-input v-model="form.depotSalary" placeholder="请输入仓库管理员工资" />
        </el-form-item>
        <el-form-item label="仓库管理员年龄" prop="depotAge">
          <el-input v-model="form.depotAge" placeholder="请输入仓库管理员年龄" />
        </el-form-item>
        <el-form-item label="仓库管理员描述" prop="depotDescription">
          <el-input v-model="form.depotDescription" placeholder="请输入仓库管理员描述" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-divider content-position="center">仓库管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDepot">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteDepot">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="depotList" :row-class-name="rowDepotIndex" @selection-change="handleDepotSelectionChange" ref="depot">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="仓库位置" prop="depotLocal" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.depotLocal" placeholder="请输入仓库位置" />
            </template>
          </el-table-column>
          <el-table-column label="仓库名" prop="depotName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.depotName" placeholder="请输入仓库名" />
            </template>
          </el-table-column>
          <el-table-column label="仓库大小" prop="depotSize" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.depotSize" placeholder="请输入仓库大小" />
            </template>
          </el-table-column>
          <el-table-column label="仓库描述" prop="depotDescription" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.depotDescription" placeholder="请输入仓库描述" />
            </template>
          </el-table-column>
          <el-table-column label="状态" prop="status" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.status" placeholder="请选择状态">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listManager, getManager, delManager, addManager, updateManager } from "@/api/database/manager";

export default {
  name: "Manager",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedDepot: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 仓库管理员管理表格数据
      managerList: [],
      // 仓库管理表格数据
      depotList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        depotManagerTelephone: null,
        depotSex: null,
        depotSalary: null,
        depotAge: null,
        depotDescription: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询仓库管理员管理列表 */
    getList() {
      this.loading = true;
      listManager(this.queryParams).then(response => {
        this.managerList = response.rows;
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
        depotManagerId: null,
        depotManagerTelephone: null,
        depotSex: null,
        depotSalary: null,
        depotAge: null,
        depotDescription: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.depotList = [];
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
      this.ids = selection.map(item => item.depotManagerId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加仓库管理员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const depotManagerId = row.depotManagerId || this.ids
      getManager(depotManagerId).then(response => {
        this.form = response.data;
        this.depotList = response.data.depotList;
        this.open = true;
        this.title = "修改仓库管理员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.depotList = this.depotList;
          if (this.form.depotManagerId != null) {
            updateManager(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManager(this.form).then(response => {
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
      const depotManagerIds = row.depotManagerId || this.ids;
      this.$modal.confirm('是否确认删除仓库管理员管理编号为"' + depotManagerIds + '"的数据项？').then(function() {
        return delManager(depotManagerIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 仓库管理序号 */
    rowDepotIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 仓库管理添加按钮操作 */
    handleAddDepot() {
      let obj = {};
      obj.depotLocal = "";
      obj.depotName = "";
      obj.depotSize = "";
      obj.depotDescription = "";
      obj.status = "";
      obj.remark = "";
      this.depotList.push(obj);
    },
    /** 仓库管理删除按钮操作 */
    handleDeleteDepot() {
      if (this.checkedDepot.length == 0) {
        this.$modal.msgError("请先选择要删除的仓库管理数据");
      } else {
        const depotList = this.depotList;
        const checkedDepot = this.checkedDepot;
        this.depotList = depotList.filter(function(item) {
          return checkedDepot.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleDepotSelectionChange(selection) {
      this.checkedDepot = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('database/manager/export', {
        ...this.queryParams
      }, `manager_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
