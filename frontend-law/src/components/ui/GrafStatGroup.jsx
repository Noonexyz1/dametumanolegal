import AreaChartGraf from "./AreaChartGraf";
import BarChartGraf from "./BarChartGraf";
import PieChartGraf from "./PieChartGraf";

export default function GrafStatGroup() {
    return (
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
            <BarChartGraf />
            <AreaChartGraf />
            <PieChartGraf />
        </div>
    )
}