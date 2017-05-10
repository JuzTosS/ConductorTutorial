package tutor.com.conductor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;

public class ConeController extends Controller {
    private int conesCount = 0;
    private TextView textField;

    public <T extends Controller & ConeListener> ConeController(int conesCount, T listener) {
        this.conesCount = conesCount;
        getArgs().putInt("conesCount", conesCount);
        setTargetController(listener);
    }

    public ConeController(@Nullable Bundle args) {
        super(args);
        conesCount = args.getInt("conesCount");
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_cone, container, false);
        textField = (TextView) view.findViewById(R.id.textField);

        view.findViewById(R.id.collectConeButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getTargetController() != null) {
                            conesCount--;
                            getArgs().putInt("conesCount", conesCount);
                            update();
                        }
                    }
                });
        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        update();
    }

    @Override
    public boolean handleBack() {
        ((ConeListener) getTargetController()).conesLeft(conesCount);
        return super.handleBack();
    }

    private void update() {
        textField.setText("Cones: " + conesCount);
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        textField = null;
    }

    public interface ConeListener {
        void conesLeft(int count);
    }
}
